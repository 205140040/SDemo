package com.demo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/GM")
public class GenerateImage {

	//ͼƬ���
	private static Integer WIDTH=120;
	private static Integer HEIGHT=50;
	
	@RequestMapping("/generateImage")
	public void generateImage(HttpServletRequest request,HttpServletResponse response) throws IOException{
		//����һ��ͼ��
		BufferedImage image=new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		//����
		Graphics g=image.getGraphics();
		//1.���ñ���ɫ  
        setBackGround(g);
      //2.���ñ߿�  
        setBorder(g);  
          
        //3.��������  
        drawRandomLine(g);  
      //4.д�����  ����  �������ֵ֤   
        String validateValue = drawRandomNum((Graphics2D)g);  
        System.out.println("��֤�룺"+validateValue);  
        //����֤��ľ���ֵ �浽session��  
        request.getSession().setAttribute("validateValue", validateValue);  
          
        //5.ͼ��д�������  
          
        //�������������      System.currentTimeMillis() ��ȡ��ǰʱ��   
        //response.setDateHeader("Expires",System.currentTimeMillis() + 1000*3600); //����1Сʱ  
          
        //�����������Ҫ��������  
        response.setDateHeader("Expires", -1);   
        response.setHeader("cache-control", "no-cache");  
        response.setHeader("pragma", "no-cache");  
          
        response.setContentType("image/jpeg");//�����������ʲô��ʽ��  
        //��ͼ����JPG�ĸ�ʽ�浽����Ȼ����� ImageIO.write�䵽�����   
        ImageIO.write(image,"jpg",response.getOutputStream()); 
	}
	
	public void setBackGround(Graphics g){
		g.setColor(Color.LIGHT_GRAY);//���ñ���ɫ
		g.fillRect(0, 0, WIDTH, HEIGHT);//����ɫȥ����������
	}
	
	public void setBorder(Graphics g){
		 //���ñ߿����ɫ �������  
        if(0 == new Random().nextInt(3))  
        {  
            g.setColor(Color.cyan);//���ñ߿���ɫ  
        }  
        else if(1 == new Random().nextInt(5))  
        {  
            g.setColor(Color.red);//���ñ߿���ɫ  
        }  
        else  
        {  
            g.setColor(Color.yellow);//���ñ߿���ɫ  
        }  
      
        g.drawRect(1, 1, WIDTH-2, HEIGHT-2);//���Ʊ߿�  
	}
	
	public void drawRandomLine(Graphics g){
		g.setColor(Color.green);  
        for(int i=0; i<5; i++)  
        {  
            //�����ó�ʼ���꣬�ͽ�������  
            int x1 = new Random().nextInt(WIDTH);//������Ҫ�ڿ��֮��  
            int y1 = new Random().nextInt(HEIGHT);//������Ҫ�ڸ߶�֮��  
            int x2 = new Random().nextInt(WIDTH);  
            int y2 = new Random().nextInt(HEIGHT);  
              
            g.drawLine(x1, y1, x2, y2);//��������  
        }  
	}

	 private String drawRandomNum(Graphics2D g)  
	    {  
	        String validateValue = "" ; // ������֤���ֵ  
	          
	        g.setColor(Color.red);  
	        g.setFont(new Font("����",Font.BOLD,28));//��������  
	          
	        //����  
	        //String base="\u4e00\u4e01\u4e02\u4e03\u4e04\u4e05\u4e06\u4e07\u4e08\u4e09";  
	        String base= "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz" ;  
	        int x=5;  
	        //�������巶Χ [\u4e00-\u9fa5]  
	        for(int i=0; i<4; i++)  
	        {  
	            int theta = new Random().nextInt()%30;//��ȡ-30��30����  
	            //String x1 = new Random().nextInt(9)+""; ����������  
	            String ch = base.charAt( new Random().nextInt(base.length()) )+"";//��ȡ��  
	      
	            g.rotate(theta*Math.PI/180, x, 30);//������ת�Ƕȣ����ȣ�  
	            g.drawString(ch, x, 30);//д�ֵ�������  
	              
	            g.rotate(-theta*Math.PI/180, x, 30);//��λ����ת��ȥ  
	            //g.drawString(x1, x, 20);  
	            x+=30;  
	            //g.drawString(x1, x, 20);  
	            //x+=30;  
	            validateValue = validateValue + ch ;  
	        }  
	          
	        return validateValue;  
	    }  
	  
}
