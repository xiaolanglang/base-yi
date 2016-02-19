package com.yilv.base.common.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.yilv.base.common.conf.Global;

public class FileUploadUtils {

	private static WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
	private static ServletContext servletContext = webApplicationContext.getServletContext();

	/**
	 * 上传文件到硬盘中,不实用文件自己的名称，使用自定义的名称，也就是会把文件的名称替换掉
	 * 
	 * @param request
	 * @param localPath
	 *            文件夹的绝对路径，但是不带后缀名，例如：D:/KaiFaRuanJian/wenjian/
	 * @param newFileName
	 *            文件名称
	 * @return
	 * @throws IOException
	 * @throws IllegalStateException
	 */
	public static List<File> upload(HttpServletRequest request, String localPath) throws IllegalStateException,
			IOException {
		// 创建一个通用的多部分解析器
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession()
				.getServletContext());
		// 判断 request 是否有文件上传,即多部分请求
		if (multipartResolver.isMultipart(request)) {
			// 转换成多部分request
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			// 取得request中的所有文件名
			Iterator<String> iter = multiRequest.getFileNames();
			List<File> fileList = new ArrayList<File>();
			while (iter.hasNext()) {
				// 取得上传文件
				MultipartFile file = multiRequest.getFile(iter.next());
				// byte[] bs = null;
				// 这部分是把文件保存在物理路径下面
				if (file != null) {
					// 取得当前上传文件的文件名称
					String fileName = file.getOriginalFilename();
					// 如果名称不为“”,说明该文件存在，否则说明该文件不存在
					if (fileName.trim() != "") {
						// 定义上传路径
						String lPath = initPath(localPath);
						File localFile = new File(lPath);
						if (!localFile.exists()) {
							localFile.mkdirs();
						}
						String newFileName = IdUtils.uuid();
						String suffix = fileName.substring(fileName.lastIndexOf("."), fileName.length());
						lPath = lPath + "/" + newFileName + suffix;
						lPath = initPath(lPath);
						File lastFile = new File(lPath);
						file.transferTo(lastFile);
						fileList.add(lastFile);
					}
				}
			}
			return fileList;
		}
		return null;
	}

	public static void download(HttpServletResponse response, HttpServletRequest request, InputStream in,
			String fileName, String size) {
		response.reset();
		response.setContentType(getContentType(fileName));
		OutputStream outp = null;
		try {
			response.addHeader("Content-Length", size);
			response.addHeader("Content-Disposition", "attachment;filename=\"" + encodeFilename(request, fileName)
					+ "\"");// 名称两边的双引号不能省略 兼容火狐 文件名中的空格
			outp = response.getOutputStream();
			byte[] b = new byte[1024];
			int i = 0;
			while ((i = in.read(b)) > 0) {
				outp.write(b, 0, i);
			}
			outp.flush();
		} catch (Exception e) {
			// e.printStackTrace();//报IO异常的部分
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				in = null;
			}
			if (outp != null) {
				try {
					outp.close();
					outp.flush();
				} catch (IOException e) {
				}
				outp = null;
			}
		}
	}

	private static String encodeFilename(HttpServletRequest request, String fileName)
			throws UnsupportedEncodingException {
		String agent = request.getHeader("USER-AGENT");
		try {
			if (null != agent && -1 != agent.indexOf("MSIE")) {
				// IE
				fileName = URLEncoder.encode(fileName, "UTF-8");
			} else if (null != agent && -1 != agent.indexOf("Mozilla")) {
				// Firefox
				fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
			}
		} catch (UnsupportedEncodingException e) {
			try {
				fileName = new String(fileName.getBytes("UTF-8"), "iso-8859-1");
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return fileName;
	}

	private static String getContentType(String fileName) {
		int position = fileName.lastIndexOf(".");
		String ext = fileName.substring(position);
		if (ext.equals(".zip")) {
			return "application/zip";
		} else if (ext.equals(".xls") || ext.equals(".xlsx")) {
			return "application/x-excel";
		} else if (ext.equals(".doc") || ext.equals(".docx")) {
			return "application/msword";
		} else if (ext.equals(".pdf")) {
			return "application/pdf";
		} else if (ext.equals(".jpg") || ext.equals(".jpeg")) {
			return "image/jpeg";
		} else if (ext.equals(".gif")) {
			return "image/gif";
		} else if (ext.equals(".png")) {
			return "image/png";
		} else if (ext.equals(".bmp")) {
			return "image/bmp";
		}
		return "application/force-download";
	}

	public static MultipartFile getUploadFile(HttpServletRequest request) {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession()
				.getServletContext());
		if (multipartResolver.isMultipart(request)) {
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			Iterator<String> iter = multiRequest.getFileNames();
			if (iter.hasNext()) {
				return multiRequest.getFile(iter.next());
			}
		}
		return null;
	}

	/**
	 * 把所有的"/"变成分割器,这种初始化路径的方式会把路径末尾的"/"去掉<br>
	 * 例如windows下：C:file/name/doc/会变成C:file\\name\\doc
	 * 
	 * @param path
	 * @return
	 */
	public static String initPath(String path) {
		if (path.indexOf("/") != -1) {
			String[] strs = path.split("/");
			path = "";
			for (int i = 0, l = strs.length; i < l; i++) {
				if (i == 0) {
					path += strs[i];
					continue;
				}
				path += File.separator + strs[i];
			}
		}
		return path;
	}

	/**
	 * 例子：输出的文件路径：D:\KaiFaRuanJian\apache-tomcat-6.0.41\webapps\wqzb\ upload
	 * 
	 * @return
	 */
	public static String getUploadPath() {
		return getPath("/WEB-INF/upload");
	}

	/**
	 * 例子：输出的文件路径：D:\KaiFaRuanJian\apache-tomcat-6.0.41\webapps\项目名称\文件夹
	 * 
	 * @param path
	 * @return
	 */
	public static String getPath(String path) {
		return servletContext.getRealPath(path);
	}

	/**
	 * 获得默认图片保存路径(这个路径是磁盘中的绝对路径，并且这是个文件夹)
	 * 
	 * @return
	 */
	public static String getDefaultImgLocalUrl() {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		String date = format.format(new Date());

		String url = Global.getConfig("web.staticFile") + "/img/" + date;

		return url;
	}

	/**
	 * 获得图片文件的访问路径(这个路径是从浏览器访问图片的路径)
	 * 
	 * @param fileName
	 *            文件名称,这个文件名称是带后缀名称
	 * @return
	 */
	public static String getDefaultImgUrl(String fileName) {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		String date = format.format(new Date());

		return Global.getImageWebPath() + "/img/" + date + "/" + fileName;
	}

}
