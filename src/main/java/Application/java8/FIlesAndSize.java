package Application.java8;

import java.util.Arrays;
import java.util.HashSet;

public class FIlesAndSize {

    int musicSize = 0;
    int imageSize = 0;
    int movieSize = 0;
    int otherSize = 0;

    HashSet musicExtensions = new HashSet<String>(){{
        add("mp3");add("aac");add("flac");
    }};

    HashSet imageExtensions = new HashSet<String>(){{
        add("jpg");add("bmp");add("gif");
    }};

    HashSet movieExtensions = new HashSet<String>(){{
        add("mp4");add("avi");add("mkv");
    }};



    public String solution(String s){
        if(s == null || s.length() == 0){
            return "";
        }
        String template = "music %sb\nimages %sb\nmovies %sb\nother %sb";

        Arrays.stream(s.split("\n"))
                .map(this::fileDataMapper)
                .forEach(fd ->
                        addToSize(getType(fd.extension),fd.sizeInBytes)
                );


        return String.format(template,musicSize,imageSize,movieSize,otherSize);

    }

    public FileData fileDataMapper(String s){
        String data[] = s.split(" ");
        return new FileData(data[0],data[1]);
    }

    void addToSize(String type,String sizeInBytes){
        int size = Integer.parseInt(sizeInBytes.contains("b")?sizeInBytes.substring(0, sizeInBytes.length()-1):sizeInBytes);
        if("music".equalsIgnoreCase(type)){
            musicSize += size;
        }else if("movie".equalsIgnoreCase(type)){
            movieSize += size;
        }else if("image".equalsIgnoreCase(type)){
            imageSize += size;
        }else {
            otherSize += size;
        }
    }
    String getType(String extension){
        if(imageExtensions.contains(extension)){
            return "image";
        }else if(movieExtensions.contains(extension)){
            return "movie";
        }else if(musicExtensions.contains(extension)){
            return "music";
        }else{
            return "other";
        }
    }



    class FileData{

        String fileName;
        String extension;
        String sizeInBytes;

        FileData(String name, String size){
            this.sizeInBytes = size;

            int lastIndexOfDot = name.lastIndexOf('.');
            this.fileName = name.substring(0,lastIndexOfDot);
            this.extension = name.substring(lastIndexOfDot+1,name.length());
        }

    }

}
