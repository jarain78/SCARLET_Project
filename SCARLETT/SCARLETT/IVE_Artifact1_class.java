
import cartago.*;
import cartago.AbstractWorkspacePoint;
import cartago.ARTIFACT_INFO;
import cartago.Artifact;
import cartago.ArtifactConfig;
import cartago.OPERATION;
import cartago.OUTPORT;
import cartago.ObsProperty;
import cartago.OpFeedbackParam;
import cartago.OperationException;


@ARTIFACT_INFO(
outports = {
@OUTPORT(name = "out-IVE_Artifact1-Id1")
}
) public class IVE_Artifact1_class extends Artifact {
	String[] saOutPos = new String[3];

	float fVelox = 0f;
	float fVeloy = 0f;
	float fVeloz = 0f;
	private boolean bflag4 = false;
	
	// attributes

	// physical properties
	// physical properties
	public ObsProperty L1;
	public ObsProperty W1;
	public ObsProperty H1;
	public ObsProperty Shape1;
	public ObsProperty Px1;
	public ObsProperty Py1;
	public ObsProperty Pz1;
	public ObsProperty VelocityX1;
	public ObsProperty VelocityY1;
	public ObsProperty VelocityZ1;
	public ObsProperty Distance1;
	public ObsProperty Angle1;
	public ObsProperty Sound1;
	public ObsProperty AccelerationX1;
	public ObsProperty AccelerationY1;
	public ObsProperty AccelerationZ1;
	public ObsProperty JointX1;
	public ObsProperty JointY1;
	public ObsProperty JointZ1;
	public ObsProperty Mass1;
	// attributes and physical properties initialization
	void init(double L, double W, double H, double Mass, double AccelerationX,
			  double AccelerationY, double AccelerationZ, String Sound,  
			  String Shape, double Angle, double Distance, int JointX, 
			  int JointY, int JointZ, double OrientationX, double OrientationY, 
			  double OrientationZ, double VelocityX, double VelocityY, 
			  double VelocityZ, double Px, double Py, double Pz){

			 //Enter your code in this line :)
			System.out.println("Iniciando el Un Linked Artifact... " + Px + " "
				+ Py + " " + Pz);

			// attributes
			// physical properties
			defineObsProperty("L", L);
			this.L1 = getObsProperty("L");
	
			defineObsProperty("W", W);
			this.W1 = getObsProperty("W");
	
			defineObsProperty("H", H);
			this.H1 = getObsProperty("H");
	
			defineObsProperty("Px", Px);
			this.Px1 = getObsProperty("Px");
	
			defineObsProperty("Py", Py);
			this.Py1 = getObsProperty("Py");
	
			defineObsProperty("pz", Pz);
			this.Pz1 = getObsProperty("pz");
	
			defineObsProperty("VelocityX", VelocityX);
			this.VelocityX1 = getObsProperty("VelocityX");
	
			defineObsProperty("VelocityY", VelocityY);
			this.VelocityY1 = getObsProperty("VelocityY");
	
			defineObsProperty("VelocityZ", VelocityZ);
			this.VelocityZ1 = getObsProperty("VelocityZ");
	
			defineObsProperty("Distance", Distance);
			this.Distance1 = getObsProperty("Distance");
	
			defineObsProperty("Angle", Angle);
			this.Angle1 = getObsProperty("Angle");
	
			defineObsProperty("Sound", Sound);
			this.Sound1 = getObsProperty("Sound");
	
			defineObsProperty("AccelerationX", AccelerationX);
			this.AccelerationX1 = getObsProperty("AccelerationX");
	
			defineObsProperty("AccelerationY", AccelerationY);
			this.AccelerationY1 = getObsProperty("AccelerationY");
	
			defineObsProperty("AccelerationZ", AccelerationZ);
			this.AccelerationZ1 = getObsProperty("AccelerationZ");
	
			defineObsProperty("JointX", JointX);
			this.JointX1 = getObsProperty("JointX");
	
			defineObsProperty("JointY", JointY);
			this.JointY1 = getObsProperty("JointY");
	
			defineObsProperty("JointZ", JointZ);
			this.JointZ1 = getObsProperty("JointZ");
	
			defineObsProperty("Mass", Mass);
			this.Mass1 = getObsProperty("Mass");
	
			defineObsProperty("Shape", Shape);
			this.Shape1 = getObsProperty("Shape");		
	}

	// acciones
	// getters & setters

	// Metering
	public void setL(float L) {
		this.L1.updateValue(L);
	}

	public Object getL() {
		return this.L1.getValue();
	}

	public void setW(float W) {
		this.W1.updateValue(W);
	}

	public Object getW() {
		return this.W1.getValue();
	}

	public void setH(float H) {
		this.H1.updateValue(H);
	}

	public Object getH() {
		return this.H1.getValue();
	}

	// Shape
	public void setShape(String Shape) {
		this.Shape1.updateValue(Shape);
	}

	public Object getShape() {
		return this.Shape1.getValue();
	}

	// Pos
	public void setPX(float PosX) {
		this.Px1.updateValue(PosX);
	}

	public Object getPX() {
		return this.Px1.getValue();
	}

	public void setPY(float PosY) {
		this.Py1.updateValue(PosY);
	}

	public Object getPY() {
		return this.Py1.getValue();
	}

	public void setPZ(float PosZ) {
		this.Pz1.updateValue(PosZ);
	}

	public Object getPZ() {
		return this.Pz1.getValue();
	}

	// Velocity
	public void setVelocityX(float VeloX) {
		this.VelocityX1.updateValue(VeloX);
	}

	public Object getVelocityX() {
		return this.VelocityX1.getValue();
	}

	public void setVelocityY(float VeloY) {
		this.VelocityY1.updateValue(VeloY);
	}

	public Object getVelocityY() {
		return this.VelocityY1.getValue();
	}

	public void setVelocityZ(float VeloZ) {
		this.VelocityZ1.updateValue(VeloZ);
	}

	public Object getVelocityZ() {
		return this.VelocityZ1.getValue();
	}

	// Distan
	public void setDistance(float Dist) {
		this.Distance1.updateValue(Dist);
	}

	public Object getDistance() {
		return this.Distance1.getValue();
	}

	// Angle
	public void setAngle(float Ang) {
		this.Angle1.updateValue(Ang);
	}

	public Object getAngle() {
		return this.Angle1.getValue();
	}

	// Sound
	public void setSound(String Soun) {
		this.Sound1.updateValue(Soun);
	}

	public Object getSound() {
		return this.Sound1.getValue();
	}

	// Aceleration
	public void setAccelerationX1(float AccX) {
		this.AccelerationX1.updateValue(AccX);
	}

	public Object getAccelerationX() {
		return this.AccelerationX1.getValue();
	}

	public void setAccelerationY(float AccY) {
		this.AccelerationY1.updateValue(AccY);
	}

	public Object getAccelerationY() {
		return this.AccelerationY1.getValue();
	}

	public void setAccelerationZ(float AccZ) {
		this.AccelerationZ1.updateValue(AccZ);
	}

	public Object getAccelerationZ() {
		return this.AccelerationZ1.getValue();
	}

	// Joint
	public void setJointX(float JointX) {
		this.JointX1.updateValue(JointX);
	}

	public Object getJointX() {
		return this.JointX1.getValue();
	}

	public void setAJointY(float JointY) {
		this.JointY1.updateValue(JointY);
	}

	public Object getJointY() {
		return this.JointY1.getValue();
	}

	public void setJointZ(float JointZ) {
		this.JointZ1.updateValue(JointZ);
	}

	public Object getJointZ() {
		return this.JointZ1.getValue();
	}

	// Mass
	public void setMass(float mass) {
		this.Mass1.updateValue(mass);
	}

	public Object getMass() {
		return this.Mass1.getValue();
	}
	
	@OPERATION
	public void stop(){
		//while(true){}
	}
	
		@OPERATION
	public void setPosUnLinkArtifact(String agentName, String Ang, String X, String Y,
			String Z, String Index, Object[] Value) throws OperationException {

		double dAngulo = Double.parseDouble(Ang);
		double dX = Double.parseDouble(X);
		double dY = Double.parseDouble(Y);
		double dZ = Double.parseDouble(Z);
		
		int iIndex = Integer.parseInt(Index);

		if (agentName.equals("Unlink_Wall_Artifact")) {
			//signal("moveBodyA");	
			// Set volocity to the Body 
			//JacaLive.SetVelocityArtifacts("ULink_0", fVelox, fVeloz, fVeloy);
			//JacaLive.SetAngleEntities("Body_0", 0.0f, 2.5f, 0.0f);
			//JacaLive.SetFrictionArtifacts("ULink_0", 0.1f);
			//JacaLive.SetDamping("Body_0", 0f, 0.01f);
			
			
			//fVelox = fVelox + 0.01f;
			//fVeloy = fVeloy + 0.01f;
			//fVeloz = fVeloz + 0.01f;
			
			//if(fAngleY<1){
				//fAngleY = fAngleY + 0.01f;
			//}
			
			if(fVelox>3){
				fVelox = 0;
				fVeloy = 0;
				fVeloz = 0;
				//fAngleY = 0;
			}
		}		
		
	}
	
	@OPERATION 
	void getPositionUnLinkArtifact(String UnartifactName){
		// ,OpFeedbackParam<String[]> PosUnArtifact,  OpFeedbackParam<Boolean> state
		//ObsProperty prop = getObsProperty("pz");
		//prop.updateValue(getPZ());
		//signal("tick");

		if (UnartifactName.equals("Unlink_Wall_Artifact")) {		
			// Update the ObserverProperty Pos
			//float[] fPosValue = JacaLive.GetPosArtifacts(UnartifactName);
			//int ix = (int)fPosValue[0];
			//int iy = (int)fPosValue[1];
			//int iz = (int)fPosValue[2];	
			//Px1.updateValue(ix);
			//Py1.updateValue(iy);
			//Pz1.updateValue(iz);
			
			// Update the ObserverProperty Velocity			
			//float[] fVeloValues = JacaLive.GetVelocityArtifacts();
			//VelocityX1.updateValue(fPosValue[0]);
			//VelocityY1.updateValue(fPosValue[1]);
			//VelocityZ1.updateValue(fPosValue[2]);
			
			// Update Map
			//JacaLive.UpdateMap("UnLink", ix, iz, iy);
					
			// Send signal to agent JacaLive
			//signal("movePosX", ix);
			//signal("movePosY", iy);
			//signal("movePosZ", iz);			
			
			//saOutPos[0] = String.valueOf(fPosValue[0]);
			//saOutPos[1] = String.valueOf(fPosValue[1]);
			//saOutPos[2] = String.valueOf(fPosValue[2]);
			
			//PosUnArtifact.set("HOLA");		
		}//else {
			//bflag4 = false;
		//}
		//state.set(bflag4);
	}
	
}
