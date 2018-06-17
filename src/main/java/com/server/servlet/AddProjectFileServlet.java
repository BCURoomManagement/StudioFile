package com.server.servlet;

import com.server.dao.ProjectFileDao;
import com.server.pojo.ProjectFile;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "AddProjectFileServlet",urlPatterns = "/AddProjectFileServlet")
public class AddProjectFileServlet extends HttpServlet {
    private static final String UPLOAD_DIRECTORY = "upload";

    //上传文件储存目录及文件名
    private  String UPLOAD_WORK = "";
    // 上传配置
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB

    ProjectFile pf=new ProjectFile();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (!ServletFileUpload.isMultipartContent(request)) {
            // 如果不是则停止
            PrintWriter writer = response.getWriter();
            writer.println("Error: 表单必须包含 enctype=multipart/form-data");
            writer.flush();
            return;
        }

        // 配置上传参数
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // 设置内存临界值 - 超过后将产生临时文件并存储于临时目录中
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        // 设置临时存储目录
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

        ServletFileUpload upload = new ServletFileUpload(factory);

        // 设置最大文件上传值
        upload.setFileSizeMax(MAX_FILE_SIZE);

        // 设置最大请求值 (包含文件和表单数据)
        upload.setSizeMax(MAX_REQUEST_SIZE);

        // 中文处理
        upload.setHeaderEncoding("UTF-8");

        // 构造临时路径来存储上传的文件
        // 这个路径相对当前应用的目录
        String uploadPath = request.getServletContext().getRealPath("./") + File.separator + UPLOAD_DIRECTORY;
        // ServletContext s1=this.getServletContext();
        //  String uploadPath=s1.getRealPath("/")+ UPLOAD_DIRECTORY;

        // 如果目录不存在则创建
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        try {
            // 解析请求的内容提取文件数据
            @SuppressWarnings("unchecked")
            List<FileItem> formItems = upload.parseRequest(request);

            if (formItems != null && formItems.size() > 0) {
                // 迭代表单数据
                for (FileItem item : formItems) {
                    // 处理不在表单中的字段
                    if (!item.isFormField()) {
                        if("word".equals(item.getFieldName())){
                            String fileName = new File(item.getName()).getName();
                            if(fileName.equals("")){
                                pf.setP_word("");
                                continue;
                            }
                            String filePath = uploadPath + File.separator + fileName;
                            File storeFile = new File(filePath);
                            // 在控制台输出文件的上传路径
                            System.out.println(filePath);
                            // 保存文件到硬盘
                            item.write(storeFile);
                            UPLOAD_WORK=filePath;
                            pf.setP_word(fileName);
                        }
                        if("code".equals(item.getFieldName())){
                            String fileName = new File(item.getName()).getName();
                            if(fileName.equals("")){
                                pf.setP_code("");
                                continue;
                            }
                            String filePath = uploadPath + File.separator + fileName;
                            File storeFile = new File(filePath);
                            // 在控制台输出文件的上传路径
                            System.out.println(filePath);
                            // 保存文件到硬盘
                            item.write(storeFile);
                            pf.setP_code(fileName);
                        }
                        if("video".equals(item.getFieldName())){
                            String fileName = new File(item.getName()).getName();
                            if(fileName.equals("")){
                                pf.setP_video("");
                                continue;
                            }
                            String filePath = uploadPath + File.separator + fileName;
                            File storeFile = new File(filePath);
                            // 在控制台输出文件的上传路径
                            System.out.println(filePath);
                            // 保存文件到硬盘
                            item.write(storeFile);
                            pf.setP_video(fileName);
                        }
                    }
                    else
                    {
                        if("u_id".equals(item.getFieldName()))
                            pf.setU_id(Integer.parseInt(new String(item.getString().getBytes(
                                    "ISO-8859-1"), "UTF-8")));
                        if ("p_name".equals(item.getFieldName()))
                            pf.setP_name(new String(item.getString().getBytes(
                                    "ISO-8859-1"), "UTF-8"));
                        if ("p_time".equals(item.getFieldName()))
                            pf.setP_time(new String(item.getString().getBytes(
                                    "ISO-8859-1"), "UTF-8"));
                    }
                }
            }
        } catch (Exception ex) {
            // request.setAttribute("message",
            //       "错误信息: " + ex.getMessage());
        }


        request.setAttribute("result",new ProjectFileDao().insertProjectFile(pf));

        request.getRequestDispatcher("/ProjectAdd.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
