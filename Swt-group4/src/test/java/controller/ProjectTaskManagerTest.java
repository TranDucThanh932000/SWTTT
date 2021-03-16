/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import model.Project;
import model.ProjectTask;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author admin2
 */
public class ProjectTaskManagerTest {
    
    public ProjectTaskManagerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    
    /**
     * Test of inforMember method, of class ProjectTaskManager.
     */
    @Test
    public void testInforMember() {
        System.out.println("inforMember");
        ProjectTaskManager ptm = new ProjectTaskManager();
        ProjectManager pm = new ProjectManager();
        ptm.inputListProjectTask();
        List<ProjectTask> list1 = ptm.getListProjectTask();
        pm.inputListProject();
        List<Project> list2 = pm.getListProject();
        if(list1.isEmpty() || list2.isEmpty()){
            assertEquals(false, true);
        }else{
            assertEquals(true, true);
            ptm.inforMember(list2);
        }
    }
    List<ProjectTask> listProjectTask = new ArrayList<>();
    private final static String FILE_URLProjectTask = "C:\\Users\\admin2\\Desktop\\SWT4-main\\SWT4-main\\inputProjectTask.txt";
    ProjectTaskManager p;

    
    @Before
    public void setUp() {
        try {
            File file = new File(FILE_URLProjectTask);
            InputStream inputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(inputStreamReader);
            try {
                String line = "";
                while ((line = reader.readLine()) != null) {
                    String[] cut = line.split("\\|");
                    listProjectTask.add(new ProjectTask(Integer.parseInt(cut[0]), cut[1], Date.valueOf(cut[2]), Date.valueOf(cut[3]), Date.valueOf(cut[4]), Integer.parseInt(cut[5]), cut[6]));
                }
            } catch (Exception e) {
                System.out.println("Error when split string " + e.getMessage());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error when inputListProjectTask() " + e.getMessage());
        }
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of gettodo method, of class ProjectTaskManager.
     */
    @Test
    public void testGettodo() {
        System.out.println("gettodo");
        int n = p.gettodo(listProjectTask);
        int m = 0;
        assertEquals(m, n, 0.0);
    }

    /**
     * Test of getdoing method, of class ProjectTaskManager.
     */
    @Test
    public void testGetdoing() {
        System.out.println("getdoing");
        int n = p.getdoing(listProjectTask);
        int m = 0;
        assertEquals(m, n, 0.0);
    }

    /**
     * Test of getcancelled method, of class ProjectTaskManager.
     */
    @Test
    public void testGetdone() {
        System.out.println("getdone");
        int n = p.getdone(listProjectTask);
        int m = 0;
        assertEquals(m, n, 0.0);
    }
    @Test
    public void testGetcancelled() {
        System.out.println("getcancelled");
        int n = p.getcancelled(listProjectTask);
        int m = 1;
        assertEquals(m, n, 0.0);
    }
    
    
}
