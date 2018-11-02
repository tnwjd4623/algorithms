package hw05;

import java.util.ArrayList;

public class SkyLine {
	private int size = 0;
	private Building B[];
	
	//Building
	private class Building {
		int left, right, height;
		
		public Building(int left, int height, int right){
			this.left = left;
			this.right = right;
			this.height = height;
		}
	}
	
	//left, height skyline
	private class _skyline {
		int lx,h;
		public _skyline(int l, int h) {
			this.lx = l;
			this.h = h;
		}
	}
	public SkyLine(int n) {
		B = new Building[n];
	}
	
	//빌딩 추가
	public void addBuilding(int left, int height, int right) {
		B[size++] = new Building(left, height, right);
	}
	
	//스카이라인 알고리즘 실행
	public void do_skyline() {
		ArrayList<_skyline> result = new ArrayList<_skyline>();
		result = findSkyline(B, 0, size-1);
		int i;
		for(i = 0; i<result.size()-1; i++) {
			System.out.print(result.get(i).lx+", "+result.get(i).h+", ");
		}
		System.out.println(result.get(i).lx+", "+result.get(i).h);
	}
	
	//findskyline
	public ArrayList<_skyline> findSkyline(Building B[], int s, int e) {
		if(s==e) {
			ArrayList<_skyline> skyline = new ArrayList<_skyline>(2);
			skyline.add(new _skyline(B[s].left, B[s].height));
			skyline.add(new _skyline(B[e].right, 0));
			return skyline;
		}
		
		int mid = (s+e)/2;
		ArrayList<_skyline> sky1 = findSkyline(B, s, mid);
		ArrayList<_skyline> sky2 = findSkyline(B, mid+1, e);
		return mergeSkyline(sky1, sky2);
	}
	
	//merge
	public ArrayList<_skyline> mergeSkyline(ArrayList<_skyline> sky1, ArrayList<_skyline> sky2) {
		int currentH1 = 0, currentH2 = 0, currentX = 0, maxH = 0;
		ArrayList<_skyline> skyline = new ArrayList<_skyline>();
		
		while(sky1.size()>0 && sky2.size()>0) {
			if(sky1.get(0).lx < sky2.get(0).lx) {
				currentX = sky1.get(0).lx;
				currentH1 = sky1.get(0).h;
				
				int new_max = Math.max(currentH1, currentH2);
				if(maxH != new_max) {
					maxH = new_max;
					skyline.add(new _skyline(currentX, maxH));
				}
				sky1.remove(0);		
			}
			else {
				currentX = sky2.get(0).lx;
				currentH2 = sky2.get(0).h;
				
				int new_max = Math.max(currentH1, currentH2);
				if(maxH != new_max) {
					maxH = new_max;
					skyline.add(new _skyline(currentX, maxH));
				}
				sky2.remove(0);
			}
		}
		
		while(sky1.size()>0) {
			skyline.add(new _skyline(sky1.get(0).lx, sky1.get(0).h));
			sky1.remove(0);
		}
		while(sky2.size()>0) {
			skyline.add(new _skyline(sky2.get(0).lx, sky2.get(0).h));
			sky2.remove(0);
		}
		
		return skyline;
	}

}
