import java.io.*;

public class C01FileClass {

    public static void main(String[] args) {

        File tmp = new File("c://upload");
//        File tmp = new File("upload");

        //1 파일&디렉토리 여부 확인
        if(tmp.isFile()){
            System.out.println("파일입니다.");
        }
        if(tmp.isDirectory()){
            System.out.println("디렉토리입니다.");
        }

        //2 경로
        System.out.println("상대경로(PATH) : " + tmp.getPath()); //상대경로
        System.out.println("절대경로(PATH) : " + tmp.getAbsolutePath()); //절대경로

        //3 디렉토리생성
        if(!tmp.exists()){ //경로체크
            tmp.mkdirs();
        }

        //4 파일 목록 확인
        File[] list = tmp.listFiles();
        System.out.println("------------------------파일목록입니다----------------------------");
        for (int i = 0; i < list.length; i++) {
            if(list[i].isFile()) {
                System.out.println("File(전체경로) : " + list[i]);
                System.out.println("File(이름만) : " + list[i].getName());
            }
            if(list[i].isDirectory()) {
                System.out.println("Directory : " + list[i]);
            }
        }
        System.out.println("-----------------------필터처리(지정파일)--------------------------------");
        //5 필터처리(원하는 파일만 가져오기)
        File[] list2 = tmp.listFiles(new FilenameFilter(){

            @Override
            public boolean accept(File dir, String name) {

                return name.contains(".pptx");
                // name.endWidth("t"); //끝문자가 t인 파일 필터
                // name.startWidth("s"); //첫문자가 s인 파일 필터
            }

        });

        for (int i = 0; i < list2.length; i++) {
            System.out.println(list2[i]);
        }

    }

}
