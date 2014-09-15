package manage.appli.patri.awb.service;

import java.io.File;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class ExecCommandeImp implements ExecCommande {

	@Override
	public void createBase() {
		// TODO Auto-generated method stub

		
		try {
			String[] command = { "cmd.exe", "/c", "Start", "E:\\create_delete\\create.bat" };
               	Runtime r = Runtime.getRuntime();
                Process p = r.exec(command);
                p.waitFor();

                } catch (Exception e) 
                {

                System.out.println("erreur d'execution"+e.getMessage());} 
		
	}

	@Override
	public void deleteBase() {
		// TODO Auto-generated method stub
		try {
			String[] command = { "cmd.exe", "/c", "Start", "E:\\create_delete\\delete.bat" };
               	Runtime r = Runtime.getRuntime();
                Process p = r.exec(command);
                p.waitFor();

                } catch (Exception e) 
                {

                System.out.println("erreur d'execution"+e.getMessage());} 

	}

	@Override
	public void loadData() {
		// TODO Auto-generated method stub
		try {
			String[] command = { "cmd.exe", "/c", "Start", "E:\\load_data.bat" };
               	Runtime r = Runtime.getRuntime();
                Process p = r.exec(command);
                p.waitFor();

                } catch (Exception e) 
                {

                System.out.println("erreur d'execution"+e.getMessage());} 

	}

	@Override
	public void exportData() {
		// TODO Auto-generated method stub
		try {
			String[] command = { "cmd.exe", "/c", "Start", "E:\\export.bat" };
               	Runtime r = Runtime.getRuntime();
                Process p = r.exec(command);
                p.waitFor();

                } catch (Exception e) 
                {

                System.out.println("erreur d'execution"+e.getMessage());} 

	}
	@Override
	public List<Countdetails> count() {
		// TODO Auto-generated method stub
		try {
			
                String[] elem ={"Database","Area","Table","Dataview datacom","Dataview Ideal","Programs","SLI","Schedule"};
                Scanner in = new Scanner(new File("E:\\create_delete\\count.txt")) ;
                PrintWriter out = new PrintWriter(new File("E:\\create_delete\\debug.txt")) ;
                List<Countdetails> res = new LinkedList<Countdetails>();
                int i=0 ;
                while(in.hasNext()){
                	
                	String line= in.nextLine().trim();
                	out.println(line);
                	if(line.equals("----------")){
                		Countdetails el = new Countdetails(elem[i],Integer.parseInt(in.nextLine().trim()));
                		i++;
                		out.println(i+" "+el.getCount()+" "+el.getElement());
                		res.add(el);
                	}
                	in.close();
                	out.close();
                }
return res ;
                } catch (Exception e) 
                {

                System.out.println("erreur d'execution"+e.getMessage());
                
                } 
		return null;
	}
	
	

}
