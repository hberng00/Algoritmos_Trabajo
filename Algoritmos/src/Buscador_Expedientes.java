import java.util.ArrayList;

public class Buscador_Expedientes {

	public static void main(String[] args) {
		ArrayList<Expediente> dataBase = new ArrayList<Expediente>();
		fill(dataBase, 0);//Crea la lista que simula la base de datos.
		
		while(true) {
		System.out.println("Introduzca la opción:\n 1.-Elegir el expediente\n 2.-Eliminar el expediente\n 3.-Salir");
		int option = Teclado.readInteger();
		int fileNumber;
		Expediente file;
		switch (option) {
		case 1:
			
			System.out.println("Introduzca el expediente:");
			fileNumber = Teclado.readInteger();
			if(fileNumber<0||fileNumber>5000) {
				System.out.println("Identificador Inválido\n");
				break;
			}
			file = binarySearch(dataBase, 0, dataBase.size(), fileNumber);
			if (file != null)
				System.out.println(file+"\n");
			break;
		case 2:
			System.out.println("Introduzca el expediente que desea eliminar:");
			fileNumber = Teclado.readInteger();
			file = binarySearch(dataBase, 0, dataBase.size(), fileNumber);
			if(fileNumber<0||fileNumber>5000) {
				System.out.println("Identificador Inválido\n");
				break;
			}
			System.out.println("Expediente "+fileNumber+" eliminado.\n");
			dataBase.remove(dataBase.lastIndexOf(binarySearch(dataBase, 0, dataBase.size(), fileNumber)));
			break;
		case 3:
			System.exit(0);
		}
		}

	}

	private static void fill(ArrayList<Expediente> dataBase, int i) {
		if (i > 5000) {
			return;
		} else {

			String file = "Archivo nº " + i;
			Expediente newFile = new Expediente(i, file);
			dataBase.add(newFile);
			fill(dataBase, ++i);

		}
	}

	//Algoritmo de busqueda binaria.
	public static Expediente binarySearch(ArrayList<Expediente> dataBase, int start, int end, int fileNumber) {
		int pos = (start + end) / 2;
		while (start <= end) {
			if (dataBase.get(pos).getNum() < fileNumber) {
				start = pos + 1;
			} else if (dataBase.get(pos).getNum() == fileNumber) {
				return dataBase.get(pos);
			} else {
				end = pos - 1;
			}
			pos = (start + end) / 2;
		}
		if (start > end) {
			System.out.println("El Expediente no existe\n");
			return null;
		}
		return binarySearch(dataBase, start, end, fileNumber);
	}
}
