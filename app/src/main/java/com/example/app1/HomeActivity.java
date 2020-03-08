package com.example.app1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.sql.*;

public class HomeActivity extends AppCompatActivity {
    EditText_txtUser,_txtPass;
    Button_btnLOGIN;
    Spinner_spinner;

private void
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        _txtPass=(EditText)findViewById(R.id.txtPass);
        _txtUser=(EditText)findViewById(R.id.txtUser);
        _btnLOGIN=(Button)findViewById(R.id.btnLOGIN);
        _spinner=(Spinner)findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(context:this,R.array.usertype,R.layout.support_simple_spinner_dropdown_item);
        _spinner.setAdapter(adapter);
        _btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                class UserDAO {
                    int mobile=Integer.parseInt(_txtUser.getText());
                    String voter_id=_txtPass.getText();
                    public User checkLogin(mobile, voter_id) throws SQLException,
                            ClassNotFoundException {
                        String jdbcURL = "jdbc:mysql://localhost:3306/login";
                        String dbUser = "root";
                        String dbPassword = "tanisha";

                        Class.forName("com.mysql.jdbc.Driver");
                        Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
                        String sql = "SELECT * FROM users WHERE mobile = ? and voter_id = ?";
                        PreparedStatement statement = connection.prepareStatement(sql);
                        statement.setString(1, mobile);
                        statement.setString(2, voter_id);

                        ResultSet result = statement.executeQuery();

                        User user = null;

                        if (result.next()) {
                            user = new User();
                            user.setFullname(result.getString("fullname"));
                            user.setEmail(email);
                        }

                        connection.close();

                        return user;
                    }
                }
            }
        }
        );
    }
}
