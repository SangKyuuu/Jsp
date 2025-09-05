package jboard.service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import jboard.dao.ArticleDAO;
import jboard.dao.FileDAO;
import jboard.dto.ArticleDTO;
import jboard.dto.FileDTO;

public enum FileService {
	
	INSTANCE;
	
	private FileDAO dao = FileDAO.getInstance();
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	public List<FileDTO> fileUpload(HttpServletRequest req) {
		
		List<FileDTO> files = new ArrayList<FileDTO>(); 
		
		// 파일업로드 디렉터리 경로 생성
		ServletContext ctx = req.getServletContext();
		String path = ctx.getRealPath("/files");
		
		File uploadPath = new File(path);		
		if(!uploadPath.exists()) {
			uploadPath.mkdir();
		}
				
		try {
			// 업로드 파일 Part(업로드된 파일) 첨부 파일에서 가져오기
			Collection<Part> parts = req.getParts();
			
			for(Part part : parts) {
				
				String partName = part.getName();
				logger.debug("partName : " + partName);
				
				if(partName.equals("file1") || partName.equals("file2")) {				
					// 파일명 추출
					String oriName = part.getSubmittedFileName();
					logger.debug("oriName : " + oriName);
					
					// 중복되지 않는 파일명 생성
					String ext = oriName.substring(oriName.lastIndexOf("."));
					String savedName = UUID.randomUUID().toString() + ext;
					
					// 파일 저장(경로 + 구분자 + 중복되지 않는 파일명)
					part.write(path + File.separator + savedName);
					
					// 반환 DTO 생성 후 리스트 저장
					FileDTO dto = new FileDTO();
					dto.setOname(oriName);
					dto.setSname(savedName);					
					files.add(dto);
				}
			}
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		return files;
	}
	
	public void fileDownload(HttpServletRequest req, HttpServletResponse resp, FileDTO fileDTO) {
		
		try {
			// 다운로드를 위한 response 헤더 정보 수정
			resp.setContentType("application/octet-stream");
			resp.setHeader("Content-Disposition", "attachment; filename="+URLEncoder.encode(fileDTO.getOname(), "UTF-8"));
			resp.setHeader("Content-Transfer-Encoding", "binary");
			resp.setHeader("Pragma", "no-cache");
			resp.setHeader("Cache-Control", "private");
	
			// 파일 스트림 작업(파일 내보내기)
			ServletContext ctx = req.getServletContext();
			String path = ctx.getRealPath("/files");
			
			File savedFile = new File(path + File.separator + fileDTO.getSname());
		
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(savedFile));
			BufferedOutputStream bos = new BufferedOutputStream(resp.getOutputStream()); // response 스트림으로 출력
			
			// 스트림 전송(파일 전송)
			bis.transferTo(bos);
			
			// 버퍼 비우기
			bos.flush();			
			// 스트림 종료
			bos.close();
			bis.close();		
		}catch (Exception e) {
			logger.error(e.getMessage());
		}			
	}
	
	public void register(FileDTO dto) {
		dao.insert(dto);
	}	
	public FileDTO findById(String fno) {
		return dao.select(fno);
	}
	public List<FileDTO> findAll() {
		return dao.selectAll();
	}
	public void modify(FileDTO dto) {
		dao.update(dto);
	}	
	
	public void downloadCountPlus(String fno) {
		dao.updateDownload(fno);
	}
	
	public void remove(int fno) {
		dao.delete(fno);
	}
}