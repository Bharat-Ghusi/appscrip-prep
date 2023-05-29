package appscripprep.javaprep.general;

public class RotatedArray {
	//Find pivot
	public static int findPivot(int[] arr) {
		int start=0,end=arr.length-1;
		while(start <= end) {
			int mid=start+(end-start)/2;
			//case-1
			if(mid < end && arr[mid] > arr[mid+1]) {
				return mid;
			}
			//Case-2
			else if( mid > start && arr[mid] < arr[mid-1]) {
				return mid-1;
			}
			//case-3
			else if(arr[mid] <= arr[start]) {
				end=mid-1;
			}
			else {
				start=mid+1;
			}
			
		}
		return -1;//Not rotated
	}
	//Binary search
	public static int binarySearch(int[] arr,int start,int end,int target) {
		while(start <= end) {
			int mid=start+(end-start)/2;
			if(arr[mid] > target) {
				end=mid-1;
			}else if(arr[mid] < target) {
				start=mid+1;
			}
			else {
				return mid;
			}
		}
		return -1;//Not found
	}
	//Rotated Array
	public static int  searchInRotatedArray(int[] arr,int target) {
		int pivot=findPivot(arr);
		//case-1
		if(pivot == -1) {
			//Array is not rotated, Just do BS
			return binarySearch(arr, 0, arr.length-1, target);
		}
		//Case-2
		else if(arr[pivot] == target) {
			return pivot;
		}
		//case-3
		else if(target >= arr[0]) {
			return binarySearch(arr, 0, pivot-1, target);
		}
		return binarySearch(arr, pivot+1, arr.length-1, target);
	}

	public static void main(String[] args) {
//		int[] arr= {3,4,5,6,1,2};
		int[] arr= {5,6,1,2,3,4};
		System.out.println(searchInRotatedArray(arr, 6));
	}

}
