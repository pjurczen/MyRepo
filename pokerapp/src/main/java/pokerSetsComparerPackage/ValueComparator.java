package pokerSetsComparerPackage;

import java.util.Comparator;

import pokerSetsComparerPackage.Enums.Value;

public class ValueComparator implements Comparator<Value>{

	@Override
	public int compare(Value value, Value valueOne) {
		if(value.frequency > valueOne.frequency) {
			return -1;
		}
		if(value.frequency < valueOne.frequency) {
			return 1;
		}
		if(value.getValueOfValue() > valueOne.getValueOfValue()) {
			return -1;
		}
		if (value.getValueOfValue() < valueOne.getValueOfValue()) {
			return 1;
		}
		return 0;
	}

}
