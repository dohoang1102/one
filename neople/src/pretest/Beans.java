package pretest;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import pretest.Bean.Column;
import pretest.Bean.Order;

public class Beans {

	public Beans() {
		super();
		this.list = new ArrayList<Bean>();
	}

	private List<Bean> list;

	public void addBean(String job, String name, String phone, String mail) {
		Bean bean = new Bean(job, name, phone, mail);
		list.add(bean);
	}

	public void sort(Column coulmn,Order order) {
		switch (coulmn) {
		case job:
			Collections.sort(list, getComparator(order,new JobSort()));
			break;
		case phone:
			Collections.sort(list, getComparator(order, new PhoneSort()));
			break;
		case name:
			Collections.sort(list, getComparator(order, new NameSort()));
			break;	
		case mail:
			Collections.sort(list, getComparator(order, new MailSort()));
			break;	
		default:
			break;
		}
	}
	
	private Comparator<Bean> getComparator(Order order,Comparator<Bean> comparator){
		if(order == Order.desc)
			comparator = Collections.reverseOrder(comparator);
		
		return comparator;
	}

	public List<Bean> getBeans() {
		return list;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Sorter [beans=");
		for (Bean bean : list) {
			builder.append(bean.toString());
		}
		builder.append("]");
		return builder.toString();
	}
	
	public ObjectOutputStream getSerializable() throws FileNotFoundException, IOException{
		return new ObjectOutputStream(new FileOutputStream("beans.dat"));
	}
}

class JobSort implements Comparator<Bean>{
	@Override
	public int compare(Bean bean, Bean targetBean) {
		return bean.getJob().compareTo(targetBean.getJob());
	}
}

class PhoneSort implements Comparator<Bean> {
	@Override
	public int compare(Bean bean, Bean targetBean) {
		return bean.getPhone().compareTo(targetBean.getPhone());
	}
}

class NameSort implements Comparator<Bean> {
	@Override
	public int compare(Bean bean, Bean targetBean) {
		return bean.getName().compareTo(targetBean.getName());
	}
}

class MailSort implements Comparator<Bean>{
	@Override
	public int compare(Bean bean, Bean targetBean) {
		return bean.getMail().compareTo(targetBean.getMail());
	}
	
}