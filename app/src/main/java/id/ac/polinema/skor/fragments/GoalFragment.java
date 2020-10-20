package id.ac.polinema.skor.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import id.ac.polinema.skor.R;
import id.ac.polinema.skor.databinding.FragmentGoalBinding;
import id.ac.polinema.skor.models.GoalScorer;

/**
 * A simple {@link Fragment} subclass.
 */
public class GoalFragment extends Fragment {

	private String requestKey;
	private GoalScorer goalScorer;

	public GoalFragment() {
		// Required empty public constructor
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.goalScorer = new GoalScorer();
		requestKey = GoalFragmentArgs.fromBundle(getArguments()).getRequestKey();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		final FragmentGoalBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_goal, container, false);
		binding.setFragments(this);
		binding.setGoalScore(goalScorer);
		return binding.getRoot();
	}

	public void onSaveClicked(View view) {
		Bundle bundle = new Bundle();
		bundle.putParcelable(requestKey, goalScorer);
		Navigation.findNavController(view).navigate(
				GoalFragmentDirections.actionGoalFragmentToScoreFragment());
	}

	public void onCancelClicked(View view) {
		Navigation.findNavController(view).navigate(
				GoalFragmentDirections.actionGoalFragmentToScoreFragment());
	}
}