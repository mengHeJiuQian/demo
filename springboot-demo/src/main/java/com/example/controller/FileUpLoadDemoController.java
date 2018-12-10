package com.example.controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author yang.liu
 * @Date 2018/12/8 11:12
 */
@Controller
public class FileUpLoadDemoController {

    private final Logger logger = LoggerFactory.getLogger(FileUpLoadDemoController.class);

    // 通过上传一定格式的“.xlsx”来选择商品id
    @POST
    @Path("/{selectType}/chooseIdsByUploadingFile")
    @Produces(MediaType.APPLICATION_JSON)
    public Object chooseIdsByUploadingFile(@Context HttpServletRequest request,
                                                   @PathParam("selectType") String type,
                                                   @RequestParam("platCode") String platCode)
            throws FileUploadException {

        logger.info("开始解析上传文件中的信息。");
        String name = "";
        if ("shop".equalsIgnoreCase(type)) {
            name = "店铺";
        } else if ("product".equalsIgnoreCase(type)) {
            name = "商品";
        }
        List<String> columnList = new ArrayList<>();
        List<String> nonExistList = new ArrayList<>();
        if (ServletFileUpload.isMultipartContent(request)) {
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload sfu = new ServletFileUpload(factory);
            List<FileItem> fileItems = sfu.parseRequest(request);
            if (null != fileItems) {
                logger.info("上传的文件数量为：{}个", fileItems.size());
                for (FileItem item : fileItems) {
                    if (!item.isFormField()) { // 文件
                        logger.info("上传文件名：{}", item.getName());
                        logger.info("上传文件大小：{}", item.getSize());
                        logger.info("上传文件类型：{}", item.getContentType());
                    }
                }
                logger.info("解析上传文件中的信息已完成。");
            }
        }
        return null;
    }

}
