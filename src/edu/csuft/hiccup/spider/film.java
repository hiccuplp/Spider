package edu.csuft.hiccup.spider;

public class film implements Comparable<film>{

	/*
	 * ӰƬ����
	 */
	String title;
	
	/*
	 * �����Ϣ
	 */
	String info;
	
	/*
	 * ���ֺ�����
	 */
	double rating ;
	
	/*
	 * ��������
	 */
	int num;
	
	/*
	 *����
	 */
	int id;
	
	/*
	 * ����
	 */
	String  poster;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getOthername() {
		return othername;
	}

	public void setOthername(String othername) {
		this.othername = othername;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getQuote() {
		return quote;
	}

	public void setQuote(String quote) {
		this.quote = quote;
	}



	/*
	 *  ����
	 * 
	 */
	String  othername;
	
	/*
	 * ӰƬ����ϸ·��
	 */
	String url;
	
	public String toCSV() {
		return String.format("%d,%s,%d,%.1f,%s\n", id,title,num,rating,quote);
	}
	
	@Override
	public String toString() {
		return "film [title=" + title + ", info=" + info + ", rating=" + rating +",othername="+othername +", num=" + num + ", id=" + id
				+ ", poster=" + poster + ", quote=" + quote + "]";
	}

	
	
	/*
	 * ����
	 */
	String quote;

	@Override
	public int compareTo(film o) {
		// TODO Auto-generated method stub
		return id-o.id;
	}
}
