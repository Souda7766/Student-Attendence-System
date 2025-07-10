
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;


 public class HOD_Window extends javax.swing.JFrame {

   
    public HOD_Window() throws SQLException {
        initComponents();
        display_graph();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1081, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 532, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   
    void display_graph() throws SQLException
    {
      
      JFreeChart barChart = ChartFactory.createBarChart("Attendance","Subjects","Number of Lectures",createDataset(),PlotOrientation.VERTICAL,true, true, false);
         
      ChartPanel chartPanel = new ChartPanel( barChart );        
      chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );        
      setContentPane( chartPanel ); 
    }
    CategoryDataset createDataset() throws SQLException
    {
        Connection conn=null;
        conn=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Akshay Chavan\\Documents\\NetBeansProjects\\Student Attendance System\\my_database.sqlite");
        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery("select * from attendance");
        
        int subject1=0,subject1_total=0,subject2=0,subject2_total=0,subject3=0,subject3_total=0,row_count=0;
        while(rs.next())
        {
            subject1+=rs.getInt(2);
            subject1_total+=rs.getInt(3);
            subject2+=rs.getInt(4);
            subject2_total+=rs.getInt(5);
            subject3+=rs.getInt(6);
            subject3_total+=rs.getInt(7);
            row_count++;
        }
        conn.close();
        
        int s1_lectures_attended=subject1/row_count;
        int s1_total_lectures=subject1_total/row_count;
        int s2_lectures_attended=subject2/row_count;
        int s2_total_lectures=subject2_total/row_count;
        int s3_lectures_attended=subject3/row_count;
        int s3_total_lectures=subject3_total/row_count;
        
        System.out.println(s1_lectures_attended+"\t"+s1_total_lectures+"\n"+s2_lectures_attended+"\t"+s2_total_lectures+"\n"+s3_lectures_attended+"\t"+s3_total_lectures);
        
        DefaultCategoryDataset dataset=new DefaultCategoryDataset();
        dataset.addValue( s1_lectures_attended , "Attended Lectures" , "Subject1");        
        dataset.addValue( s2_lectures_attended , "Attended Lectures" , "Subject2" );
        dataset.addValue( s3_lectures_attended , "Attended Lectures" , "Subject3" );

        dataset.addValue( s1_total_lectures , "Total Lectures" , "Subject1" );        
        dataset.addValue( s2_total_lectures , "Total Lectures" , "Subject2" );
        dataset.addValue( s3_total_lectures , "Total Lectures" , "Subject3" );
        

        
        return dataset;
    }
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new HOD_Window().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(HOD_Window.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
