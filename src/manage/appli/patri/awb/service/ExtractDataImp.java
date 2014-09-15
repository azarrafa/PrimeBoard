package manage.appli.patri.awb.service;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;



public class ExtractDataImp implements ExtractData {

	static List<String> listpgm = new LinkedList<String>();
	Hashtable<String, String> listprg = new Hashtable<String, String>();
	static List<String> listdataview = new LinkedList<String>();
	static Map<String,String> listsli = new Hashtable<String,String>();

	@Override
	public void extractDataCom(String file) {

		Scanner in;
		PrintWriter out, out1, out2, out3;

		String database_name = null;
		String database_dbid = null;
		String database_user = null;
		String area_dbname = null;
		String area_name = null;
		String table_name = null;
		String dataview_name = null;
		String table_relat_dataview = null;

		try {
			in = new Scanner(new File(file));

			out = new PrintWriter(new File("E:\\OUTPUT\\DATABASE_AWB.csv"));
			out1 = new PrintWriter(new File("E:\\OUTPUT\\AREA_AWB.csv"));
			out2 = new PrintWriter(new File("E:\\OUTPUT\\TABLE_AWB.csv"));
			out3 = new PrintWriter(new File("E:\\OUTPUT\\DATAVIEW_DATACOM.csv"));

			boolean pass = false;
			boolean pass1 = false;
			boolean pass2 = false;
			boolean pass3 = false;

			String str = null;
			while (in.hasNext()) {

				str = in.nextLine().trim();
				if (str.startsWith("-BTG DATABASE,")) {
					database_name = (str.split("-BTG DATABASE,"))[1];
					String[] tr = database_name.split("\\(");
					database_name = tr[0].trim();
					while (!str.startsWith("-END")) {
						if (str.startsWith("1001")) {
							database_user = str.split("1001")[1];
							StringTokenizer tok = new StringTokenizer(
									database_user);
							database_user = tok.nextToken();
							database_user = database_user.replace("'", " ");
							database_user = database_user.trim();

						}
						if (str.startsWith("2900")) {
							database_dbid = str.split("2900")[1];
							StringTokenizer tok = new StringTokenizer(
									database_dbid);
							database_dbid = tok.nextToken();
							database_dbid.trim();

						}

						str = in.nextLine().trim();
					}
					if (pass)
						out.println();
					else
						pass = true;
					out.print(database_name + "," + database_dbid + ","
							+ database_user);
					// out.print(database_name);
				}

				if (str.startsWith("-BTG AREA,")) {
					area_name = (str.split("-BTG AREA,"))[1];
					area_name = area_name.split("\\(")[0];
					area_name = area_name.trim();
					while (!str.startsWith("-END")) {
						if (str.startsWith("1000")) {
							database_name = str.split("1000")[1].trim();
							database_name = str.split("CONNECT,")[1].trim();
						}
						if (str.startsWith("3001"))
							area_dbname = str.split("3001")[1].trim();

						// System.out.println("---AREA :" + area_name);
						// System.out.println("---AREA_DBNAME :" + area_dbname);

						str = in.nextLine().trim();
					}
					if (pass1)
						out1.println();
					else
						pass1 = true;
					out1.print(area_name + "," + area_dbname + ","
							+ database_name);
					// out1.print(database_name);

				}

				if (str.startsWith("-BTG TABLE,")) {
					table_name = str.split("-BTG TABLE,")[1];
					table_name = table_name.split("\\(")[0];
					table_name = table_name.trim();
					// System.out.println("TABLE_NAME :" + table_name);
					while (!str.startsWith("-END")) {
						if (str.startsWith("1000")) {
							area_name = str.split("1000")[1].trim();
							area_name = str.split("CONNECT,")[1].trim();
						}

						str = in.nextLine().trim();
					}

					if (pass2)
						out2.println();
					else
						pass2 = true;
					out2.print(table_name + "," + area_name);

				}

				if (str.startsWith("-BTG DATAVIEW,")) {
					dataview_name = str.split("-BTG DATAVIEW,")[1];
					dataview_name = dataview_name.split("\\(")[0];
					dataview_name = dataview_name.trim();
					// System.out.println("DATAVIEW :" + dataview_name);

					while (!str.startsWith("1003 RELT,ELEMENT,"))
						str = in.nextLine().trim();

					if (str.startsWith("1003 RELT,ELEMENT,")) {
						table_relat_dataview = str.split("1003 RELT,ELEMENT,")[1];

						table_relat_dataview = table_relat_dataview.replace(
								".", "");
						table_relat_dataview.trim();
						// System.out.println("RELAT TO :" +
						// table_relat_dataview);

						if (pass3)
							out3.println();
						else
							pass3 = true;
						listdataview.add(dataview_name);
						out3.print(dataview_name + "," + table_relat_dataview);
					}

				}

			}

			in.close();
			out.close();
			out1.close();
			out2.close();
			out3.close();
		} catch (IOException e) {
			System.out.print(e.getMessage());
		}

	}

	@Override
	public void extractSched(String file) {
		Scanner in;
		PrintWriter out;
		PrintWriter out1;
		PrintWriter out3;

		String schedule = null;
		String nb_job = "";
		String description = null;
		String job = null;
		String jobnb = null;
		String libmemb = null;
		String Class = null;
		String sublib = null;
		String sysid = null;
		String fail_code = null;
		String job_appel=null;
		String autosel=null ;
		boolean pass = false, pass2 = false, pass3 = false;

		int nb_job_int = 0;

		Map<String, String> key = new TreeMap<String, String>();

		try {
			in = new Scanner(new File(file));
			out = new PrintWriter(new File("E:\\OUTPUT\\SCHEDULER.csv"));
			out1 = new PrintWriter(new File("E:\\OUTPUT\\SLI.csv"));
			out3 = new PrintWriter(new File("E:\\OUTPUT\\RELAT_SLI_SCHED.csv"));
           
			String strtmp = in.nextLine();
			while (in.hasNext()) {

				if (strtmp.startsWith(" SCHEDULE BASE RECORD")) {

					description = "";
					while (!strtmp.startsWith(" JOB BASE RECORD")) {
						strtmp = in.nextLine();
						if (strtmp.startsWith(" SCHEDULE=")) {

							strtmp = strtmp.split(" SCHEDULE=")[1];
							schedule = strtmp.split("SCHD PRTY")[0].trim();
						}
						if (strtmp.contains("NO OF JOBS  =")) {
							strtmp = strtmp.split("NO OF JOBS  =")[1];
							nb_job = strtmp.split("BACKLOG")[0].trim();
							if (nb_job.length() == 0) {
								nb_job_int = 0;
								nb_job = "" + 0;
								break;
							}
							nb_job_int = Integer.parseInt(nb_job);
						}
						if (strtmp.contains("DESCRIPTION=")) {
							strtmp = strtmp.split("DESCRIPTION=")[1];
							description = strtmp.split("QUANTITY")[0].trim();
							description = description.replace(",", ".");
							description = description.replace(";", ".");

						}
						if (strtmp.contains("AUTO SELECT")) {
							StringTokenizer autos=new StringTokenizer(strtmp);
							autos.nextToken();
							autos.nextToken();
							autos.nextToken();
							autosel=autos.nextToken();

						}
					}
					if (pass)
						out.println();
					else
						pass = true;
					if (description.length() == 0)
						description = "pas de description";
					out.print(schedule + "," + nb_job + "," + autosel + ","+ description);
					if (nb_job_int != 0) {
						while (nb_job_int != 0) {

							//
							if (strtmp.startsWith(" JOB BASE RECORD")) {
								while (!strtmp.startsWith(" JOB:"))
									strtmp = in.nextLine();
								String[] tmp = strtmp.split("=");
								job = tmp[0];
								job = job.split(" JOB:")[1];
								job = job.split("EARLY TIME")[0].trim();
								Class = tmp[3];
								Class = Class.split("AUTO START")[0].trim();
								while (!strtmp.startsWith(" JOB#"))
									strtmp = in.nextLine();
								strtmp = strtmp.split(" JOB#")[1];
								jobnb = strtmp.split("MUST  TIME")[0].trim();
								while (!strtmp.contains("SUBLIB"))
									strtmp = in.nextLine();
								if (!strtmp.contains("ICCFLIBN")) {
									strtmp = strtmp.split("SUBLIB")[1];
									sublib = strtmp.split("JMR REC")[0];
									sublib = sublib.replace("=", " ").trim();
								} else
									sublib = "";
								while (!(strtmp.contains("LIBMEMB") && strtmp
										.contains("SYSID")))
									strtmp = in.nextLine();
								strtmp = strtmp.split("LIBMEMB      =")[1];
								String[] tmps = strtmp.split("SYSID       =");
								libmemb = tmps[0].trim();
								sysid = tmps[1].split("DRIVER PARMS")[0].trim();
								while (!strtmp.contains("FAIL CODE"))
									strtmp = in.nextLine();
								strtmp = strtmp.split("FAIL CODE   =")[1];
								fail_code = strtmp.split("JCR REC")[0].trim();

								nb_job_int--;
							} else {
								strtmp = in.nextLine();
								continue;
							}
							
							
							if(listsli.containsKey(job))  job_appel=listsli.get(job);
							else job_appel="inexist";
							if (pass2)
								out3.println();
							else
								pass2 = true;
                             
							out3.print(job + "," + schedule);
							key.put(job, jobnb + "," + libmemb + "," + Class
									+ "," + sublib + "," + sysid + ","
									+ fail_code+","+job_appel);
							
							
						}

					}

				}

				else {
					strtmp = in.nextLine();

				}
			}
			// System.out.print(base);

			for (Map.Entry<String, String> entree : key.entrySet()) {
				if (pass3)
					out1.println();
				else
					pass3 = true;

				out1.print(entree.getKey() + "," + entree.getValue());
			}
			;

			in.close();
			out.close();
			out1.close();
			out3.close();

		} catch (IOException e) {
			System.out.print(e.getMessage());

		}

	}

	@Override
	public void extractPrograms(String file) {
		Scanner in;
		PrintWriter out, out1, out2, out3, out4, out5, out6, out7;
		String name = null;
		String version = null;
		String status = null;
		String date_c = null;
		String date_m = null;
		String dataview = null;
		String system = null;
		String report = null;
		String panel = null;
		String use_pgm = null;

		try {
			in = new Scanner(new File(file));
			out = new PrintWriter(new File("E:\\OUTPUT\\PROGRAMS.csv"));
			out1 = new PrintWriter(new File("E:\\OUTPUT\\RELAT_DATACOM.csv"));
			out2 = new PrintWriter(new File("E:\\OUTPUT\\RELAT_IDEAL.csv"));
			out3 = new PrintWriter(new File("E:\\OUTPUT\\DATAVIEW_IDEAL.csv"));
			out4 = new PrintWriter(new File("E:\\OUTPUT\\USE_REPORT.csv"));
			out5 = new PrintWriter(new File("E:\\OUTPUT\\USE_PANEL.csv"));
			out6 = new PrintWriter(new File("E:\\OUTPUT\\USE_PGM.csv"));
			out7 = new PrintWriter(new File("E:\\OUTPUT\\ANOM_PRG_DV.csv"));
			boolean pass = false;
			boolean pass1 = false;
			boolean pass2 = false;
			boolean pass3 = false;
			boolean pass4 = false;
			boolean pass5 = false;
			boolean pass6 = false;
			boolean pass7 = false;
			String jeton = null;

			Map<String, Integer> monHashtable = new Hashtable<String, Integer>();
			jeton = in.nextLine().trim();
			while (in.hasNext()) {

				if (jeton.startsWith("->PROGRAM")) {

					StringTokenizer token = new StringTokenizer(jeton);
					name = token.nextToken();
					name = token.nextToken();
					token.nextToken();
					version = token.nextToken();
					token.nextToken();
					system = token.nextToken();

					String elem = name + " " + system;
					
						
						listprg.put(elem, version);
						//System.out.println("innnnnnnnnnnnnnnnnnn");
					
						

					// System.out.println();
					while (!jeton.contains("->END-PROGRAM")) {
						if (jeton.startsWith("STATUS")) {
							jeton = jeton.split("STATUS")[1];
							StringTokenizer token1 = new StringTokenizer(jeton);
							status = token1.nextToken();

						}
						if (jeton.contains("DATE-CREATED")) {
							jeton = jeton.split("DATE-CREATED")[1];
							StringTokenizer token1 = new StringTokenizer(jeton);
							date_c = token1.nextToken();
							// System.out.println(date_c);

						}
						if (jeton.contains("DATE-MODIFIED")) {
							jeton = jeton.split("DATE-MODIFIED")[1];
							StringTokenizer token1 = new StringTokenizer(jeton);
							date_m = token1.nextToken();
							// System.out.println(date_m);

						}
						if (jeton.startsWith("USES-DATAVIEW")) {
							jeton = jeton.split("USES-DATAVIEW")[1];
							String versions = "";
							StringTokenizer token1 = new StringTokenizer(jeton);
							dataview = token1.nextToken();
							token1.nextToken();
							versions = token1.nextToken();
							versions = versions.trim();

							// System.out.println(versions.length());

							if (listdataview.contains(dataview)) {

								if (pass1)
									out1.println();
								else
									pass1 = true;
								out1.print(dataview + "," + name + ","
										+ version + "," + system);

							} else {

								// k++;
								//

								// System.out.println(","+k);
								if (versions.length() == 4) {
									if (pass7)
										out7.println();
									else
										pass7 = true;
									out7.print(dataview + "," + name + ","
											+ version + "," + system);

								}
								if (versions.length() == 3) {
									monHashtable.put(dataview, new Integer(1));
									if (pass2)
										out2.println();
									else
										pass2 = true;
									out2.print(dataview + "," + name + ","
											+ version + "," + system);
								}

							}
						}

						if (jeton.startsWith("USES-PANEL")) {
							// jeton = jeton.split("USES-PANEL")[1];

							StringTokenizer token1 = new StringTokenizer(jeton);
							token1.nextToken();
							panel = token1.nextToken();
							token1.nextToken();
							String ver_pan = token1.nextToken();
							if (pass5)
								out5.println();
							else
								pass5 = true;
							out5.print(panel + "," + ver_pan + "," + name + ","
									+ version + "," + system);

							// System.out.println(versions.length());

						}
						if (jeton.startsWith("USES-REPORT")) {
							// jeton = jeton.split("USES-PANEL")[1];

							StringTokenizer token1 = new StringTokenizer(jeton);
							token1.nextToken();
							report = token1.nextToken();
							token1.nextToken();
							String ver_rep = token1.nextToken();

							if (pass4)
								out4.println();
							else
								pass4 = true;
							out4.print(report + "," + ver_rep + "," + name
									+ "," + version + "," + system);

							// System.out.println(versions.length());

						}
						if (jeton.startsWith("USES-PROGRAM")) {
							// jeton = jeton.split("USES-PANEL")[1];

							StringTokenizer token1 = new StringTokenizer(jeton);
							token1.nextToken();
							use_pgm = token1.nextToken();
							token1.nextToken();
							String vers = token1.nextToken();
							token1.nextToken();
							String sys = "";
							if (jeton.contains("SYSTEM")) {
								sys = token1.nextToken();
							}
							if (pass6)
								out6.println();
							else
								pass6 = true;
							if (sys.length() == 0)
								sys = "$ID";
							out6.print(use_pgm + "," + vers + "," + sys + ","
									+ name + "," + version + "," + system);

							// System.out.println(versions.length());

						}

						jeton = in.nextLine().trim();
					}
					if (pass)
						out.println();
					else
						pass = true;
					out.print(name + "," + version + "," + status + ","
							+ date_c + "," + date_m + "," + system);

				}

				else
					jeton = in.nextLine().trim();

			}

			Set<String> key = monHashtable.keySet();

			Iterator<String> it = key.iterator();
			while (it.hasNext()) {
				if (pass3)
					out3.println();
				else
					pass3 = true;
				out3.print(it.next());

			}
			in.close();
			out.close();
			out1.close();
			out2.close();
			out3.close();
			out4.close();
			out5.close();
			out6.close();
			out7.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}

	@Override
	public void extractSLI(String file) {
		Scanner in;
		PrintWriter out, out1, out2, out3, anom;
		String job_appel = null;
		String urt = null;
		String program = null;
		String job = null;
		String system = null;
		String part = null;
		String idf = null;
		String parm = null;
		boolean pass = false;
		boolean entre = false;
		boolean pass1 = false;
		boolean pass2 = false;
		boolean pass3 = false;
		boolean pass4 = false;

		try {
			in = new Scanner(new File(file));
			out = new PrintWriter(new File("E:\\OUTPUT\\JOB_APPEL.csv"));
			out1 = new PrintWriter(new File("E:\\OUTPUT\\URT.csv"));
			out2 = new PrintWriter(new File("E:\\OUTPUT\\RUN_PRG.csv"));
			out3 = new PrintWriter(new File("E:\\OUTPUT\\CFT.csv"));
			
			anom = new PrintWriter(new File("E:\\OUTPUT\\ANOM_RUN_PRG.csv"));
			String jeton = "";
			out.println("inexist,inexist");
			while (in.hasNext()) {
				

				if (jeton.startsWith("CATALOG ")) {
                    system="empty";
					jeton = jeton.split("CATALOG ")[1];
					StringTokenizer token1 = new StringTokenizer(jeton);

					job_appel = token1.nextToken();
					entre = false;
					program = "====================";
					while (!jeton.startsWith("/+") && in.hasNext()) {
						if (jeton.startsWith("// JOB")) {
							jeton = jeton.split("// JOB")[1];
							token1 = new StringTokenizer(jeton);
							job = token1.nextToken();

						}

						if (jeton.startsWith("SET RUN URT")) {
							jeton = jeton.split("SET RUN URT")[1];
							StringTokenizer token = new StringTokenizer(jeton);

							urt = token.nextToken();
							if (pass1)
								out1.println();
							else
								pass1 = true;
							out1.print(job_appel + "," + urt);

							// System.out.println("urt :"+urt);
						}

						if (jeton.startsWith("SEND")) {
							if (jeton.contains("IDF")) {
								String[] tm;
								jeton = jeton.split("SEND")[1].trim();
								tm = jeton.split(",");
								if (tm.length == 2) {
									part = tm[0].trim().split("PART=")[1];
									idf = tm[1].trim().split("IDF=")[1];
									idf = (new StringTokenizer(idf))
											.nextToken();
									parm = "&parm";

								}
								if (tm.length == 3) {
									part = tm[0].split("PART=")[1];
									idf = tm[1].trim().split("IDF=")[1];
									idf = (new StringTokenizer(idf))
											.nextToken();
									if (tm[2].startsWith("PARM="))
										parm = tm[2].trim().split("PARM=")[1];

								}
								if (pass3)
									out3.println();
								else
									pass3 = true;
								if (parm.length() == 0)
									parm = "&parm";
								out3.print(job_appel + "," + part + "," + idf
										+ "," + parm);
							} else {
								jeton = jeton.split("SEND")[1].trim();
								StringTokenizer toks = new StringTokenizer(
										jeton);
								toks.nextToken();
								toks.nextToken();
								part = toks.nextToken().replace(",", "");
								jeton = in.nextLine();
								if (jeton.contains("IDF")) {
									toks = new StringTokenizer(jeton);
									toks.nextToken();
									toks.nextToken();
									idf = toks.nextToken().replace(",", "");
								}
								if (pass3)
									out3.println();
								else
									pass3 = true;
								out3.print(job_appel + "," + part + "," + idf
										+ "," + parm);
							}
							parm = "&parm";
						}

						if (jeton.startsWith("SELECT SYS")
								|| jeton.startsWith("SEL SYS")) {
							entre = true;
							
							if (jeton.startsWith("SELECT SYS"))
								if (jeton.startsWith("SELECT SYSTEM")) {
									
									StringTokenizer token = new StringTokenizer(
											jeton);
                                    token.nextToken();
                                    token.nextToken();
									system = token.nextToken();

								} else {
									StringTokenizer token = new StringTokenizer(
											jeton);
                                    token.nextToken();
                                    token.nextToken();
									system = token.nextToken();

								}
							if (jeton.startsWith("SEL SYS")) {
								StringTokenizer token = new StringTokenizer(
										jeton);
                                token.nextToken();
                                token.nextToken();
								system = token.nextToken();

							}

						}

						if (jeton.startsWith("RUN")) {
							jeton = jeton.split("RUN ")[1];
							StringTokenizer token = new StringTokenizer(jeton);

							program = token.nextToken();

							Set<String> set = listprg.keySet();
                             if(system.equals("empty")) system="$ID" ;
							String fd = program + " " + system;

							if (set.contains(fd)) {

								if (pass2)
									out2.println();
								else
									pass2 = true;
								if (entre)
									out2.print(job_appel + "," + program + ","
											+ listprg.get(fd)+","+system);
								else
									out2.print(job_appel + "," + program
											+","+ listprg.get(fd)+",$ID");

							} else {
								if (pass4)
									anom.println();
								else
									pass4 = true;
								if (entre)
									anom.print(job_appel + "," + program + ","
											+ system);
								else
									anom.print(job_appel + "," + program
											+ ",$ID");

							}
							
						}

						jeton = in.nextLine().trim();
					}

					// while(!jeton.startsWith("/&")){
					//
					// if(jeton.startsWith("SET RUN ")){
					// jeton=jeton.split("SET RUN")[1];
					// StringTokenizer token=new StringTokenizer(jeton);
					// urt=token.nextToken();
					// urt=token.nextToken();
					//
					// System.out.println("urt :"+urt);
					// }
					// if(jeton.startsWith("RUN ")){
					// jeton=jeton.split("RUN ")[1];
					// StringTokenizer token=new StringTokenizer(jeton);
					// program=token.nextToken();
					// System.out.println("programs :"+program);
					// }
					//
					// jeton=in.nextLine();
					//
					//
					// }
					
					
						if (pass)
							out.println();
						else
							pass = true;
						if (job.equals("false"))
							job = job_appel.replace(".S", "");
						out.print(job_appel + "," + job);
						listsli.put(job,job_appel);
					

				}

				else {
					jeton = in.nextLine().trim();
				}

			}
			// out.print(job_appel + ",," + j + i);
			out.close();
			out1.close();
			out2.close();
			out3.close();
			anom.close();
			in.close();
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.print(e.getMessage());
		}

	}

}
