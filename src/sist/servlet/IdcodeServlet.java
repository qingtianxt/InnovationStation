package sist.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sist.utils.StringUtil;

/**
 * 生成验证码的Servlet
 */
@WebServlet("/IdcodeServlet")
public class IdcodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String randomStr = StringUtil.randomStr(4).toUpperCase();
		System.out.println(randomStr);
		BufferedImage image = getValidCodeImage(randomStr);
		ImageIO.write(image, "JPEG", response.getOutputStream());
		request.getSession().setAttribute("validateCode", randomStr);
	}

	private Color getRandColor(int fc,int bc){
		Random random = new Random();
		if (fc > 255)
			fc = fc%255;
		if (bc > 255)
			bc = bc%255;
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}
	
	public BufferedImage getValidCodeImage(String code){
		// 在内存中创建图象
		int width = 60, height = 22;
		BufferedImage image = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);

		// 获取图形上下文
		Graphics g = image.getGraphics();

		//生成随机类
		Random random = new Random();

		// 设定背景色
		g.setColor(getRandColor(200, 250));
		g.fillRect(0, 0, width, height);

		//设定字体
		g.setFont(new Font("Times New Roman", Font.PLAIN, 18));

		//画边框
		//g.setColor(new Color());
		//g.drawRect(0,0,width-1,height-1);

		// 随机产生155条干扰线，使图象中的认证码不易被其它程序探测到
		g.setColor(getRandColor(160, 200));
		for (int i = 0; i < 155; i++) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int xl = random.nextInt(12);
			int yl = random.nextInt(12);
			g.drawLine(x, y, x + xl, y + yl);
		}
		char[] sRand = code.toCharArray();
		int length = sRand.length;
		for(int i= 0; i < length; i++){
			g.setColor(new Color(20 + random.nextInt(110), 20 + random
					.nextInt(110), 20 + random.nextInt(110)));// 调用函数出来的颜色相同，可能是因为种子太接近，所以只能直接生成
			g.drawString(String.valueOf(sRand[i]), 13*i+6, 16);
		}
		g.dispose();
		return image;
	}
}
