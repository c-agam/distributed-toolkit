package com.czlt.reproduction.mgr.utils;


import java.io.*;

public class IOUtils {

    public static String readStreamAsString(InputStream in, String charset)
            throws IOException {

        if (in == null) {
            return "";
        }

        Reader reader = null;
        Writer writer = new StringWriter();
        String result;

        char[] buffer = new char[1024];
        try {
            int n = -1;
            reader = new BufferedReader(new InputStreamReader(in, charset));
            while((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }

            result = writer.toString();
        } finally {
            in.close();
            if (reader != null) {
                reader.close();
            }
            if (writer != null) {
                writer.close();
            }
        }

        return result;
    }

    public static byte[] readStreamAsByteArray(InputStream in)
            throws IOException {

        if (in == null) {
            return new byte[0];
        }

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = -1;
        while ((len = in.read(buffer)) != -1) {
            output.write(buffer, 0, len);
        }
        output.flush();
        return output.toByteArray();
    }


    public static void deleteFile(File file){
        if(file != null){
            if(file.exists()){
                if(file.isFile()){
                    file.delete();
                }else if(file.isDirectory()){
                    String[] fileList = file.list();
                    if(fileList != null && fileList.length > 0){
                        for(String fileItem : fileList){
                            deleteFile(new File(file, fileItem));
                        }
                    }else{
                        file.delete();
                    }
                }
            }
            file.delete();
        }
    }

    public static void closeSilently(Closeable ...closeables) {
        if(closeables != null) {
            for(Closeable closeable : closeables) {
                if(closeable != null) {
                    try {
                        closeable.close();
                    } catch (IOException ioe) {
                        ioe.printStackTrace();
                    }
                }
            }
        }
    }
}

