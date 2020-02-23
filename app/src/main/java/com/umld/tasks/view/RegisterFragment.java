package com.umld.tasks.view;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.umld.tasks.R;
import com.umld.tasks.model.ModelCallback;
import com.umld.tasks.model.ModelError;
import com.umld.tasks.model.Users;
import com.umld.tasks.repository.RegisterCredentials;
import com.umld.tasks.repository.RegisterRepository;
import com.umld.tasks.repository.UserRepsitory;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment {

    private TextView btRegister;
    private TextView btLogin;
    private EditText edFullname;
    private EditText edUsername;
    private EditText edPassword;
    RegisterRepository registerRepository;

    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_register, container, false);

        btLogin    = view.findViewById(R.id.btLogin);
        btRegister = view.findViewById(R.id.btRegister);
        edFullname = view.findViewById(R.id.edFullname);
        edUsername = view.findViewById(R.id.edUsername);
        edPassword = view.findViewById(R.id.edPassword);

        registerRepository = new RegisterRepository(getActivity());

        btRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                registerRepository.getRegistredUser(new RegisterCredentials(edFullname.getText().toString(),edUsername.getText().toString(),edPassword.getText().toString()), new ModelCallback<Users>() {

                    @Override
                    public void onResult(Users result) {
                        if(result.getSuccess()){
                            // if login true then show Task list fragment
                            MainActivity.fragmentManager.beginTransaction().replace(R.id.mainFrame, new LoginFragment(), null).commit();
                        }
                    }

                    @Override
                    public void onError(ModelError error) {

                    }
                });
            }
        });

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.fragmentManager.beginTransaction().replace(R.id.mainFrame, new LoginFragment(), null).commit();
            }
        });

        return view;
    }

}
