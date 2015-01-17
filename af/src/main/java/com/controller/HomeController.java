package com.controller;

import java.io.File;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@Autowired
	private ServletContext servletContext;

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	@RequestMapping(value = { "/" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	public String home(Model model) {
		logger.info("Welcome home!");

		return "home";
	}

	@RequestMapping(value = { "/uploadTask" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	public String uploadTask(Model model) {
		logger.info("uploadTask");

		return "upload-task";
	}

	@RequestMapping(value = { "/uploadTask" }, method = { org.springframework.web.bind.annotation.RequestMethod.POST })
	public void uploadTask(Model model, HttpServletRequest request,
			HttpServletResponse response) {
		logger.info("uploadFile");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=null;
		try {
			out = response.getWriter();
			File file;
			int maxFileSize = 5000 * 1024;
			int maxMemSize = 5000 * 1024;
			// ServletContext context = request.get
			// ServletContext servletContext = request.getServletContext()
			String filePath = servletContext.getRealPath("");

			// System.out.println("RealPath"+request.getSession().getServletContext().getRealPath(""));
			// System.out.println("RealPath(ServletContext)"+context.getRealPath(""));

			// Verify the content type
			String contentType = request.getContentType();
			if ((contentType.indexOf("multipart/form-data") >= 0)) {

				DiskFileItemFactory factory = new DiskFileItemFactory();
				// maximum size that will be stored in memory
				factory.setSizeThreshold(maxMemSize);
				// Location to save data that is larger than maxMemSize.
				// System.out.println("java.io.tmpdir: "+System.getProperty("java.io.tmpdir"));
				factory.setRepository(new File(System
						.getProperty("java.io.tmpdir")));

				// Create a new file upload handler
				ServletFileUpload upload = new ServletFileUpload(factory);
				// maximum file size to be uploaded.
				upload.setSizeMax(maxFileSize);
				try {
					// Parse the request to get file items.
					List fileItems = upload.parseRequest(request);

					// Process the uploaded file items
					Iterator i = fileItems.iterator();

					out.println("<html>");
					out.println("<head>");
					out.println("<title>JSP File upload</title>");
					out.println("</head>");
					out.println("<body>");
					while (i.hasNext()) {
						FileItem fi = (FileItem) i.next();
						if (!fi.isFormField()) {
							// Get the uploaded file parameters
							String fieldName = fi.getFieldName();
							String fileName = fi.getName();
							boolean isInMemory = fi.isInMemory();
							long sizeInBytes = fi.getSize();
							// Write the file
							if (fileName.lastIndexOf("\\") >= 0) {
								file = new File(filePath
										+ "/resources/"
										+ fileName.substring(fileName
												.lastIndexOf("\\")));
							} else {
								file = new File(filePath
										+ "/resources/"
										+ fileName.substring(fileName
												.lastIndexOf("\\") + 1));
							}
							fi.write(file);
							out.println("Uploaded Filename: " + filePath
									+ "/resources/" + fileName + "<br>");
							out.println("Access via : <a href=\""
									+ request.getScheme() + "://"
									+ request.getServerName() + ":"
									+ request.getServerPort()
									+ request.getContextPath() + "/resources/"
									+ fileName + "\">" + request.getScheme()
									+ "://" + request.getServerName() + ":"
									+ request.getServerPort()
									+ request.getContextPath() + "/resources/"
									+ fileName + "</a>");
						}
					}
					out.println("<br/><br/><br/><br/><a href=\""+request.getScheme() + "://"
							+ request.getServerName()+"\">Back</a>");
					out.println("</body>");
					out.println("</html>");
				} catch (Exception ex) {
					System.out.println(ex);
				}
			} else {
				out.println("<html>");
				out.println("<head>");
				out.println("<title>Servlet upload</title>");
				out.println("</head>");
				out.println("<body>");
				out.println("<p>No file uploaded</p>");
				out.println("</body>");
				out.println("</html>");
			}

		} catch (Exception e) {

		} finally {
			if (out != null) {
				out.flush();
				out.close();
			}
		}
	}
}