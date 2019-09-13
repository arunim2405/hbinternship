package daySix;

import java.io.IOException;

public interface Bank {
 void newAccount() throws IOException, ClassNotFoundException ;
void viewAccount() throws IOException, ClassNotFoundException ;
void withdrawAccount() throws IOException, ClassNotFoundException ;
void updateRecord()throws IOException, ClassNotFoundException;

}
