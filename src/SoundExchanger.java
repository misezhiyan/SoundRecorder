import java.io.File;

public class SoundExchanger {

	// ������·��
	private static final String lamePath = "F:\\lame\\lame";

	public static void main(String[] args) {
		File file = new File("F:/workSpace/eclipse_webservice/SoundRecorder/src/musicTmp/1553217026740.wav");
		File tarFile = new File("F:/workSpace/eclipse_webservice/SoundRecorder/src/musicTmp/1553217026740.mp3");
		wavToMp3(file, tarFile);
	}

	public static void wavToMp3(File file, File tarFile) {

		Runtime run = null;
		// ���Ե�ǰ��·��
		try {
			run = Runtime.getRuntime();
			// ���ñ���������wav�ļ�ת��Ϊmp3�ļ�
			// �ѱ���õ���mp3�ļ��ȴ�ŵ�D���£�Ȼ�������ļ��������������ŵ�ָ�����ļ�����ͬʱ��D���µ��ļ�ɾ��
			// Process p = run.exec(filePath + "/" + "lame -b 16 " + filePath + "/" + file.getName() + " " + tarPath + tarFile.getName()); // 16Ϊ���ʣ��������޸�
			String process = lamePath + " -b 16 " + tarFile.getParentFile().getAbsolutePath() + "/" + file.getName() + " " + tarFile.getParentFile().getAbsolutePath() + "/" + tarFile.getName();
			Process p = run.exec(lamePath + " -b 16 " + tarFile.getParentFile().getAbsolutePath() + "/" + file.getName() + " " + tarFile.getParentFile().getAbsolutePath() + "/" + tarFile.getName()); // 16Ϊ���ʣ��������޸�
			// �ͷŽ���
			p.getOutputStream().close();
			p.getInputStream().close();
			p.getErrorStream().close();
			// �ȴ�
			p.waitFor();

			// //ɾ��֮ǰ����ĵ�wav�ļ�
			// if(file.exists())
			// {
			// file.delete();
			// }

			// //��������Ҫ��ŵ��ļ�·��
			// String destPath = "D:/Program Files/apache-tomcat-6.0.35/webapps/XWZ/tempFile/";
			// copyFile(tarPath+tarFile.getName(), destPath);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// ���Ҫִ�е����
			// run����lame����������ͷ��ڴ�
			run.freeMemory();
		}

	}

}
