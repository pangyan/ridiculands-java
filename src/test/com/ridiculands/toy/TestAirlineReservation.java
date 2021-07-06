package com.ridiculands.toy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

public class TestAirlineReservation {

	public static void main(String[] args) {
		System.err.println("Start arranging seats...");

		// Initialize input
		// seats
		Integer[][] block1 = new Integer[3][2];
		Integer[][] block2 = new Integer[4][3];
		Integer[][] block3 = new Integer[2][3];
		Integer[][] block4 = new Integer[3][4];
		List<Integer[][]> seats = new ArrayList<Integer[][]>();
		seats.add(block1);
		seats.add(block2);
		seats.add(block3);
		seats.add(block4);
		// passengers
		List<Integer> passengers = new ArrayList<Integer>();
		passengers.add(1);
		passengers.add(2);
		passengers.add(3);
		passengers.add(4);
		passengers.add(5);
		passengers.add(6);
		passengers.add(7);
		passengers.add(8);
		passengers.add(9);
		passengers.add(10);
		passengers.add(11);
		passengers.add(12);
		passengers.add(13);
		passengers.add(14);
		passengers.add(15);
		passengers.add(16);
		passengers.add(17);
		passengers.add(18);
		passengers.add(19);
		passengers.add(20);
		passengers.add(21);
		passengers.add(22);
		passengers.add(23);
		passengers.add(24);
		passengers.add(25);
		passengers.add(26);
		passengers.add(27);
		passengers.add(28);
		passengers.add(29);
		passengers.add(30);

		TestAirlineReservation test = new TestAirlineReservation();
		seats = test.arrange(seats, passengers);
		test.display(seats);

		System.err.println("End arranging seats...");
	}

	private List<Integer[][]> arrange(List<Integer[][]> seats, List<Integer> passengers) {
		List<Seat> aisleSeatList = extractAisle(seats);
		List<Seat> windowSeatList = extractWindow(seats);
		List<Seat> centerSeatList = extractCenter(seats);
		
		int passengerIndex = 0;
		Integer passenger = null;
		for (Seat seat : aisleSeatList) {
			if (passengerIndex < passengers.size() && (passenger = passengers.get(passengerIndex)) != null) {
				seats.get(seat.getBlock())[seat.getColumn()][seat.getRow()] = passenger;
			}
			passengerIndex++;
		}
		for (Seat seat : windowSeatList) {
			if (passengerIndex < passengers.size() && (passenger = passengers.get(passengerIndex)) != null) {
				seats.get(seat.getBlock())[seat.getColumn()][seat.getRow()] = passenger;
			}
			passengerIndex++;
		}
		for (Seat seat : centerSeatList) {
			if (passengerIndex < passengers.size() && (passenger = passengers.get(passengerIndex)) != null) {
				seats.get(seat.getBlock())[seat.getColumn()][seat.getRow()] = passenger;
			}
			passengerIndex++;
		}


//		for (Seat seat : centerSeatList) {
//			System.err.println(seat.getBlock() + ", " + seat.getColumn() + ", " + seat.getRow());
//		}
		return seats;
	}

	private List<Seat> extractAisle(List<Integer[][]> seats) {
		List<Seat> seatList = new ArrayList<Seat>();
		int blockNumber = 0;
		Seat seat = null;

		for (Integer[][] block : seats) {
			int cols = block.length - 1;
			int rows = block[0].length;

			for (int i = 0; i < rows; i++) {
				if (blockNumber != 0) {
					seat = new Seat(blockNumber, 0, i);
					seatList.add(seat);
				}

				if (blockNumber != seats.size() - 1) {
					seat = new Seat(blockNumber, cols, i);
					seatList.add(seat);
				}
			}

			blockNumber++;
		}

		Collections.sort(seatList);
		return seatList;
	}

	private List<Seat> extractWindow(List<Integer[][]> seats) {
		List<Seat> seatList = new ArrayList<Seat>();
		int blockNumber = 0;
		Seat seat = null;

		for (Integer[][] block : seats) {
			int cols = block.length - 1;
			int rows = block[0].length;

			for (int i = 0; i < rows; i++) {
				if (blockNumber == 0) {
					seat = new Seat(blockNumber, 0, i);
					seatList.add(seat);
				}

				if (blockNumber == seats.size() - 1) {
					seat = new Seat(blockNumber, cols, i);
					seatList.add(seat);
				}
			}

			blockNumber++;
		}

		Collections.sort(seatList);
		return seatList;
	}

	private List<Seat> extractCenter(List<Integer[][]> seats) {
		List<Seat> seatList = new ArrayList<Seat>();
		int blockNumber = 0;
		Seat seat = null;

		for (Integer[][] block : seats) {
			int cols = block.length - 1;
			int rows = block[0].length;

			for (int i = 0; i < rows; i++) {
				for (int j = 1; j < cols; j++) {
					seat = new Seat(blockNumber, j, i);
					seatList.add(seat);
				}
			}

			blockNumber++;
		}

		Collections.sort(seatList);
		return seatList;
	}

	private void display(List<Integer[][]> seats) {
		int blockNumber = 1;
		for (Integer[][] block : seats) {
			int columnNumber = 0;
			for (Integer[] col : block) {
				int rowNumber = 0;
				for (Integer passenger : col) {
					System.err.println("[Block " + blockNumber + " Column " + columnNumber + " Row " + rowNumber + "]: passenger " + passenger);
					rowNumber++;
				}
				columnNumber++;
			}
			blockNumber++;
			System.err.println("========================="); 
		}
	}

	private class Seat implements Comparable<Seat> {
		Integer block;
		Integer column;
		Integer row;

		public Seat(Integer block, Integer column, Integer row) {
			this.block = block;
			this.column = column;
			this.row = row;
		}

		public Integer getColumn() {
			return column;
		}

		public void setColumn(Integer column) {
			this.column = column;
		}

		public Integer getRow() {
			return row;
		}

		public void setRow(Integer row) {
			this.row = row;
		}

		public Integer getBlock() {
			return block;
		}

		public void setBlock(Integer block) {
			this.block = block;
		}

		@Override
		public int compareTo(Seat arg0) throws ClassCastException {
			if (this.row < arg0.getRow()) {
				return -1;
			} else if (this.row > arg0.getRow()) {
				return 1;
			}

			if (this.block < arg0.getBlock()) {
				return -1;
			} else if (this.block > arg0.getBlock()) {
				return 1;
			}

			if (this.column < arg0.getColumn()) {
				return -1;
			} else if (this.column > arg0.getColumn()) {
				return 1;
			}

			return 0;
		}
	}
}
