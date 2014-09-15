package manage.appli.patri.awb.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ConcatFileImp implements ConcatFile {

	@Override
	public boolean concat(String[] infile, String outfile) {
		
		
		File list;
		PrintWriter out;
		Scanner in ;

		    try {
		    	
		    	list = new File("INPUT");
		    	infile=list.list();
		    	out = new PrintWriter(new File(outfile)) ;
		    	 out = new PrintWriter(new FileWriter(outfile,true));

		    	for (int i = 0; i < infile.length; i++) {
            	if(infile[i].startsWith("EXPGM")){ in = new Scanner(new File("INPUT\\"+infile[i]));
            	
            	while(in.hasNext()) out.println(in.nextLine());
            	
            	System.out.println(infile[i]);
				in.close();
            	}
		        }
		    	out.close();

		       
		    } catch(IOException e) {
		    	System.out.println(e.getMessage());
		    	return false;
		    	
		    	
		    }
		
		
		return true;
	}
	
	@Override
	public List<Filedetail> listfile() {
		File list = new File("E:\\output") ;
	   
		File[] listes =list.listFiles();
		List<Filedetail> res=new LinkedList<Filedetail>() ;
		Filedetail current = null ;
		if(listes!=null)
		{	for (int i = 0; i < listes.length; i++) {
			current =new Filedetail(listes[i].getName(),""+listes[i].length());
			res.add(current);
		}
		return res;
		}
		else {current = new Filedetail("dossier OUTPUT vide ou inexistant","0") ;
	
		res.add(current) ;return res;} 
	}
	
	@Override
	public List<Filedetail> listfilein() {
		// TODO Auto-generated method stub
		File list = new File("E:\\input") ;
		
		File[] listes =list.listFiles();
		List<Filedetail> res=new LinkedList<Filedetail>() ;
		Filedetail current = null ;
		if(listes!=null)
		{	for (int i = 0; i < listes.length; i++) {
			current =new Filedetail(listes[i].getName(),""+listes[i].length());
			res.add(current);
		}
		return res;
		}
		else {current = new Filedetail("dossier OUTPUT vide ou inexistant","0") ;
	
		res.add(current) ;return res;} 
	}
	@Override
	public boolean deletefiles() {
		
		File list = new File("E:\\output") ;
		   
		File[] listes =list.listFiles();
	
	    
		if(listes!=null)
		{	for (int i = 0; i < listes.length; i++) {
			if(listes[i].delete()) continue;
			else return false;
		}
		return true ;
		}
		else {
	
		return false;
		
		} 
	
		
	}

}
