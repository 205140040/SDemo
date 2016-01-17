package servlet;

import java.io.IOException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Base64Demo {
	public static void main(String[] args) throws IOException {
		String pwdOld = "cAeVreyo-eA7TR-d-ftUWnxTEe5LQvSWzY1LGmqOc94_";
		BASE64Encoder encoder = new BASE64Encoder();
		String newPwd = encoder.encode(pwdOld.getBytes());
		System.out.println("base64编码后：" + newPwd);
		BASE64Decoder decoder = new BASE64Decoder();
		String decoderStr = new String(decoder.decodeBuffer("cAeVreyo-eA7TR-d-ftUWnxTEe5LQvSWzY1LGmqOc94_"));
		System.out.println("base64解码后：" + decoderStr);
	}
}
