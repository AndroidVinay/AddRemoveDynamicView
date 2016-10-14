package com.vinay.addremovedynamicview;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {

	AppCompatButton btn_add, btn_submit;
	EditText edt;
	LinearLayout llContainer;



	public BlankFragment() {
		// Required empty public constructor
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View view = inflater.inflate(R.layout.fragment_blank, container, false);

		btn_add = (AppCompatButton) view.findViewById(R.id.btn_add_btn);
		btn_submit = (AppCompatButton) view.findViewById(R.id.btn_submit);
		edt = (EditText) view.findViewById(R.id.edt);
		llContainer = (LinearLayout) view.findViewById(R.id.ll_container);
		btn_add.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				LayoutInflater layoutInflater =
						(LayoutInflater) getActivity().getSystemService(Context
								.LAYOUT_INFLATER_SERVICE);
				final View addView = layoutInflater.inflate(R.layout.row, null);
				EditText edtOut = (EditText) addView.findViewById(R.id.edtout);
//				textOut.setText(edt.getText().toString());
				Button buttonRemove = (Button) addView.findViewById(R.id.remove);
				buttonRemove.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						((LinearLayout) addView.getParent()).removeView(addView);
					}
				});
				llContainer.addView(addView);
			}
		});


		btn_submit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				StringBuffer bf = new StringBuffer();

				for (int i = 0; i < llContainer.getChildCount(); i++) {
					View v = llContainer.getChildAt(i);
					String s = ((EditText) v.findViewById(R.id.edtout)).getText().toString();
					bf.append(s);
				}

				Toast.makeText(getActivity(), "String is " + bf.toString(), Toast.LENGTH_SHORT)
						.show();
			}
		});
		return view;
	}

}
