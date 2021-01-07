
public class Expediente {
		private int num;
		private String file;

		Expediente(int num, String file) {
			this.setNum(num);
			this.setFile(file);
		}

		public int getNum() {
			return num;
		}

		public void setNum(int num) {
			this.num = num;
		}

		public String getFile() {
			return file;
		}

		public void setFile(String file) {
			this.file = file;
		}

		@Override
		public String toString() {
			return "Expediente [" + file + "]";
		}
		
	}