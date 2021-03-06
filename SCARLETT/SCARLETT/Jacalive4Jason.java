import jason.architecture.AgArch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Hashtable;

import JaCalIVEFrameWork.JaCalIVEFrameWork;
import JaCalIVEFrameWork.JaCalIVEWorkSpace;
import SaveLogFile.SaveLogFile;
import cartago.AgentId;
import cartago.ArtifactConfig;
import cartago.CartagoNode;
import cartago.CartagoWorkspace;
import cartago.WorkspaceKernel;

public class Jacalive4Jason extends JaCalIVEFrameWork {

	static JaCalIVEWorkSpace jacalIVE_WorkSpace = new JaCalIVEWorkSpace();
	static SaveLogFile csvLog = new SaveLogFile();

	CartagoWorkspace cartWork;
	ArtifactConfig ConfigArti;
	CartagoNode Node;
	WorkspaceKernel WorkSpaKernel;
	java.util.Set<String> list = null;
	static String[] args1 = new String[18];

	static JaCalIVEFrameWork jacalIVE;

	float[] PosXYZ = { 0f, 0f, 0f };

	int iPosiX = 0;
	int iPosiY = 0;
	int iPosiZ = 0;
	String sPosiX = "";

	String sPosXYZ = " ";

	static File newTextFile;
	static FileWriter fw;

	int conta = 0;

	public Jacalive4Jason() {
		new Hashtable<String, AgentId>();
	}

	public void initJacaLive(String ManagerOrAgent, String sName, int numWsP, int TamaLinkArtifact, int TamaUnLinkArtifact, int TamaBodyArti,
			double Gx, double Gy, double Gz, int Wmap, int Hmap, int Lmap, boolean bGravity, float fGroundFriction,
			String Floor, int HostPort, String HostName, String RendeOnOff) throws Exception {

		//
		/** initialize de Nodos, Workspace etc **/
		Node = CartagoNode.getInstance();
		/** Config Artifact **/
		ConfigArti = new ArtifactConfig();
		/** Create the workspace **/
		cartWork = Node.createWorkspace(sName);

		WorkSpaKernel = cartWork.getKernel();

		AgArch userAgArch = new AgArch();

		System.out.println("-----------------------------------------------");
		ClassLoader cl = ClassLoader.getSystemClassLoader();
		URL[] urls = ((URLClassLoader) cl).getURLs();
		for (URL url : urls) {
			System.out.println(url.getFile());
		}
		System.out.println("-----------------------------------------------");
		
		args1[0] = ManagerOrAgent;
		args1[1] = sName;
		args1[2] = Integer.toString(numWsP);
		args1[3] = Integer.toString(TamaLinkArtifact);
		args1[4] = Integer.toString(TamaUnLinkArtifact);
		args1[5] = Integer.toString(TamaBodyArti);
		args1[6] = Double.toString(Gx);
		args1[7] = Double.toString(Gy);
		args1[8] = Double.toString(Gz);
		args1[9] = Integer.toString(Wmap);
		args1[10] = Integer.toString(Hmap);
		args1[11] = Integer.toString(Lmap);
		args1[12] = Boolean.toString(bGravity);
		args1[13] = Double.toString(fGroundFriction);
		args1[14] = Floor;
		args1[15] = Integer.toString(HostPort);
		args1[16] = HostName;
		args1[17] = RendeOnOff;

		main(args1);
		// Creation and initialization of Workspace
		JaCalIVEWorkSpace.iniWsp(Node, ConfigArti, cartWork, WorkSpaKernel, userAgArch);

		String FileName = "CsvLog.csv";

		csvLog.init(FileName);

		String[] Headers = { "CE P", "CE A", "CE D", "P", "A", "D", "maxDistP", "maxDistA", "maxDistD", "stdP", "stdA",
				"stdD" };
		csvLog.instanceToOutput(FileName, Headers);

		newTextFile = new File("CsvLog.txt");
		fw = new FileWriter(newTextFile);

	}

	/*
	 * public void activateRender(boolean FlagRender)throws Exception{
	 * activateRenderToJaCalIVE(); if(FlagRender==true){ viewRender(FlagRender);
	 * } }
	 */

	public String getPosOfBodyArtifact(String name) {
		PosXYZ = getPosOfBodyArtifacts(name);

		sPosXYZ = Float.toString(PosXYZ[0]) + ", " + Float.toString(PosXYZ[1]) + ", " + Float.toString(PosXYZ[2]);

		return sPosXYZ;

	}

	public void setNameBodys(String name, int index) {
		System.out.println(name + " " + index);
		setNameBodyArtifact(name, index);
	}

	public void createBodys() {
		createBody();
	}

	public void timeDelays() throws InterruptedException {
		timeDelay();
	}

	public void getSizeOfArtifacts() {
		System.out.println(getNumOfArtifacts());
	}

	public Boolean sendRender(String data) throws IOException {
		return sendRenders(data);
	}

	public void inObsProperty(String Type, String Name, double L, double W, double H, double Mass, double AccelerationX,
			double AccelerationY, double AccelerationZ, String Sound, String Shape, double Angle, double Distance,
			int JointX, int JointY, int JointZ, double OrientationX, double OrientationY, double OrientationZ,
			double VelocityX, double VelocityY, double VelocityZ, double Px, double Py, double Pz) {

		Object[] param = { Type, Name, L, W, H, Mass, AccelerationX, AccelerationY, AccelerationZ, Sound, Shape, Angle,
				Distance, JointX, JointY, JointZ, OrientationX, OrientationY, OrientationZ, VelocityX, VelocityY,
				VelocityZ, Px, Py, Pz };
		inputObsProperty(param);
	}

	
	public void readTxtFiles(String fileName) throws IOException {
		readFileTXT(fileName);
	}

	public String readPythonScript(String Args, String Path) throws IOException {
		return runPythonScript(Args, Path);
	}

	public String dynamicEmotion(String Data) throws IOException {
		String NewStr = "";

		String Data1 = Data.replace("[", "");
		String Data2 = Data1.replace("]", "");
		String Data3 = Data2.replace("	", " ");

		int Tama = Data3.length();

		String[] parts = Data3.substring(0, Tama).split(", ");

		for (int i = 0; i < parts.length; i++) {
			NewStr += parts[i] + " ";
		}

		String tad = runPythonScript(NewStr, "../PythonScript/Dynamic.py");

		return tad;

	}

	public void saveTXT(String Data) {
		try {
			fw.write(Data);
		} catch (IOException iox) {
			iox.printStackTrace();
		}
	}

	public void closeFile() {
		try {
			fw.close();
		} catch (IOException iox) {
			iox.printStackTrace();
		}

	}

	public void saveCsV(String Data) throws IOException {
		String NewStr = "";
		String Data1 = Data.replace("[", "");
		String Data2 = Data1.replace("]", "");
		String Data3 = Data2.replace("	", " ");

		int Tama = Data3.length();

		String[] parts = Data3.substring(0, Tama).split(", ");

		for (int i = 0; i < parts.length; i++) {
			NewStr += parts[i] + " ";
		}

		csvLog.saveCSV1(NewStr, " ");
	}

	public void iterationControl(int End) {

		System.out.println(conta);
		conta++;
	}

	public void powerOffPC() {
		Process p;
		String s;
		try {
			p = Runtime.getRuntime().exec("poweroff");
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			while ((s = br.readLine()) != null)
				System.out.println("line: " + s);
			p.waitFor();
			System.out.println("exit: " + p.exitValue());
			p.destroy();
		} catch (Exception e) {
		}
		//
	}


	public void runNodeScript(String Path){
		initToRunNodeScript(Path);
	}


	public void init_Vision() {
		initJaCalIVE_Vision(1);
	}


	public void take_Photo() {
		try {
			TakePhoto();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void getPosObj() {
		System.out.println(getCoordinates());
	}

	// SDA
	public void sendDataSDA(String data) {
		sendData_SDA(data);
	}

	public void multiClientServerSDA() throws Exception {
		initServerSDA();
	}

	public void hashtableIsEmpty(){
		System.out.println(isEmpty());
	}

	// STT
	public void init_Sound_Recorder(String WavPath, int TimerRecorder){
		initSoundRecorder(WavPath, TimerRecorder);
	}
	
	public boolean start_Thread_Record(){
		return startThreadRecord();
	}
	
	
	// Agents
	//public void getIPAgents(){
	//	System.out.println(getAgentAddres());
	//}
	
	//public void sendMessageToAgent(String msg){
	//	sendDataToAgent(msg);
	//}
	
	public void initAgentServer(){
		//initDistributedServer();
	}

	//public String readMessage(){
	//	return getAgentAddres();
	//}
}


