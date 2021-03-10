package com.example.umbrellaarea.umbrellaarea.Controller;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class QRCode {
    public QRCode() {
    }

    public QRCode(String text,String qrname ) {
        try {
            createQRCodeImage(text,qrname, 350, 350, 0x00000000, 0xFFFFFFFF);
        }catch (WriterException | IOException e){
            System.out.println(e);
        }
    }

    public void createQRCodeImage(String text,String qrname, int width, int height, int qrDarkColor, int qrLightColor)throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        //  AWS  IP 주소 수정요망   이미 Ip
        String hostQR="http://172.30.1.38:8080/myorder/"+text;
        BitMatrix bitMatrix = qrCodeWriter.encode(hostQR, BarcodeFormat.QR_CODE, width, height); //텍스트, 바코드 포맷,가로,세로
        MatrixToImageConfig config = new MatrixToImageConfig(qrDarkColor , qrLightColor); //진한색, 연한색
        BufferedImage qrImage = MatrixToImageWriter.toBufferedImage(bitMatrix , config);


        ImageIO.write(qrImage, "png",new File("/Users/gimdongmin/Downloads/umbrella-area/src/main/resources/static/QRCode/"+qrname) ); //temp 위치에 qr이 이미지 생성됨.
        //InputStream is = new FileInputStream(temp.getAbsolutePath()); // 인풋 스트림으로 변환(향후 S3로 업로드하기위한 작업)
        // /Users/gimdongmin/Downloads/umbrella-area/src/main/resources/static/QRCode
        //로직처리후 temp.delete() 와 is.close()를 해줘야함.

    }
}
