package hackerearcth;

import java.util.ArrayList;
import java.util.Scanner;

class FolderStructure{
	public FolderStructure(String string) {
		// TODO Auto-generated constructor stub
		directoryName = string ;
	}
	public ArrayList<FolderStructure> folderStructure = new ArrayList<FolderStructure>();
	public  String directoryName = "";
	
}

public class linuxFile {
	
	static public  String queryFolder = "";


	public static void main(String [] args){
		
	FolderStructure rootNode = new  FolderStructure("root");		
		
	Scanner scan = new Scanner(System.in);	
	String parentName ;
	String childName ;
	
    int N = scan.nextInt();
    for (int i = 0; i < N; i++) {
    
    	parentName = scan.next(); 
    	childName = scan.next();     
    	add(parentName,childName,rootNode);		
    }

    int Q = scan.nextInt();
    for (int i = 0; i < Q; i++) {
    
    	String query = scan.next(); 
    	find(query,rootNode);	
        System.out.println(linuxFile.queryFolder);
    }
        


		
	}

	private static  void find(String parentName,FolderStructure rootNode) {
		// TODO Auto-generated method stub

		// Find Parent
		FindPath(rootNode ,parentName );
		
			
			
		}

	private static boolean  FindPath(FolderStructure rootNode, String parentName){
		// TODO Auto-generated method stub
		

		
		if(rootNode.directoryName.equals(parentName)){		
			queryFolder += "/"+rootNode.directoryName;
			return true;
		}
			
		
		
		for(FolderStructure f : rootNode.folderStructure){
			if( FindPath(f,parentName) == true){
				if(rootNode.directoryName.equals("root")){
					int a =0;
					a++;
				}
				
				else
					queryFolder = "/"+rootNode.directoryName+queryFolder;
			
				return true;
			}

		}
			
		return false;
		
	}
		

	private static  void add(String parentName, String childName,FolderStructure rootNode) {
		// TODO Auto-generated method stub

		// Find Parent
		FolderStructure parentFolder = FindParent(rootNode ,parentName ,rootNode);
		parentFolder.folderStructure.add(new FolderStructure(childName));
			
			
		}

	private static FolderStructure FindParent(FolderStructure rootfiles ,String parentName,FolderStructure rootNode) {
		// TODO Auto-generated method stub
		
		if(rootfiles.directoryName.equals(parentName))
			return rootfiles;
		
		
		for(FolderStructure f : rootfiles.folderStructure){
			return FindParent(f,parentName,rootNode);
		}
			
		return rootNode;
		
	}
		
		
		
}
	
