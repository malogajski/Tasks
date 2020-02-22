package com.umld.tasks.view;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.umld.tasks.R;
import com.umld.tasks.model.ModelCallback;
import com.umld.tasks.model.ModelError;
import com.umld.tasks.model.Sessions;
import com.umld.tasks.repository.UserCredentials;
import com.umld.tasks.repository.UserRepsitory;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    private Button btLogin;
    private Button btRegister;
    private EditText edUsername;
    private EditText edPassword;
    UserRepsitory userRepsitory;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        btLogin = view.findViewById(R.id.btLogin);
        btRegister = view.findViewById(R.id.btRegister);
        edUsername = view.findViewById(R.id.edUsername);
        edPassword = view.findViewById(R.id.edPassword);

        userRepsitory = new UserRepsitory(getActivity());

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Login and get session here ---------------------

                userRepsitory.getUser(new UserCredentials(edUsername.getText().toString(),edPassword.getText().toString()), new ModelCallback<Sessions>() {
                    @Override
                    public void onResult(Sessions result) {
                        if(result.getSuccess()){
                            // if login true then show Task list fragment
                            MainActivity.fragmentManager.beginTransaction().replace(R.id.mainFrame, new TaskList(), null).commit();
                        }
                    }

                    @Override
                    public void onError(ModelError error) {
                        //network error
                        //password not good
                        //etc...
                    }
                });


            }
        });

        btRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.fragmentManager.beginTransaction().replace(R.id.mainFrame, new RegisterFragment(), null).commit();
            }
        });


        return view;
    }

}
