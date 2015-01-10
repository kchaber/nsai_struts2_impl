package pl.dmcs.nsai.struts2.utils;

import java.util.ArrayList;
import java.util.List;

public class CollectionUtil {
	public static <TYPE> List<TYPE> iterableToList(Iterable<TYPE> iterable) {
		List<TYPE> list = new ArrayList<TYPE>();
		for (TYPE item : iterable) {
			list.add(item);
		}
		return list;
	}
}
