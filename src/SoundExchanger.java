import java.io.File;

public class SoundExchanger {

	// 解码器路径
	private static final String lamePath = "F:\\lame\\lame";

	public static void main(String[] args) {
		File file = new File("F:/workSpace/eclipse_webservice/SoundRecorder/src/musicTmp/1553217026740.wav");
		File tarFile = new File("F:/workSpace/eclipse_webservice/SoundRecorder/src/musicTmp/1553217026740.mp3");
		wavToMp3(file, tarFile);
	}

	public static void wavToMp3(File file, File tarFile) {

		Runtime run = null;
		// 测试当前的路径
		try {
			run = Runtime.getRuntime();
			// 调用编码器来将wav文件转换为mp3文件
			// 把编码得到的mp3文件先存放到D盘下，然后利用文件拷贝函数将它放到指定的文件夹下同时将D盘下的文件删除
			// Process p = run.exec(filePath + "/" + "lame -b 16 " + filePath + "/" + file.getName() + " " + tarPath + tarFile.getName()); // 16为码率，可自行修改
			String process = lamePath + " -b 16 " + tarFile.getParentFile().getAbsolutePath() + "/" + file.getName() + " " + tarFile.getParentFile().getAbsolutePath() + "/" + tarFile.getName();
			Process p = run.exec(lamePath + " -b 16 " + tarFile.getParentFile().getAbsolutePath() + "/" + file.getName() + " " + tarFile.getParentFile().getAbsolutePath() + "/" + tarFile.getName()); // 16为码率，可自行修改
			// 释放进程
			p.getOutputStream().close();
			p.getInputStream().close();
			p.getErrorStream().close();
			// 等待
			p.waitFor();

			// //删除之前保存的的wav文件
			// if(file.exists())
			// {
			// file.delete();
			// }

			// //定义最终要存放的文件路径
			// String destPath = "D:/Program Files/apache-tomcat-6.0.35/webapps/XWZ/tempFile/";
			// copyFile(tarPath+tarFile.getName(), destPath);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 最后都要执行的语句
			// run调用lame解码器最后释放内存
			run.freeMemory();
		}

	}

}
