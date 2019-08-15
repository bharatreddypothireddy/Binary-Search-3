// Time Complexity :O(N)  
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// 1 . Find index where given number is present in array or find its closest element and initialize left and right positions as left and right of this index.
// 2. Now , since array is sorted , first add left element then right element till array is in bounds and number of neighbours less than k and
//    increment both pointers. 
// 3. Now , if left or right positions out of bounds add opposite pointer elements and increment pointer till number of closest elements is k.
import java.util.ArrayList;
import java.util.List;

public class kClosestElements {

        public static List<Integer> findClosestElements(int[] arr, int k, int x) {
            int position = findindex(arr,x,0,arr.length-1);
            List<Integer> result = new ArrayList<>();
            int count = 0;
            int left,right;
            if(arr[position] == x){
                left = position-1;
                right = position+1;
                result.add(arr[position]);
                k--;
            }
            else if(arr[position] > x){
                left = position-1;
                right = position;
            }
            else{
                left = position;
                right = position+1;
            }
            while(k>0 && left>=0 && right<=arr.length-1){
                if(x-arr[left]<=arr[right]-x){
                    result.add(0,arr[left]);
                    left--;
                    k--;
                }
                else{
                    result.add(arr[right]);
                    right++;
                    k--;
                }
            }
            while(k>0 && left>=0){
                result.add(0,arr[left]);
                left--;
                k--;
            }
            while(k>0 && right<=arr.length-1){
                result.add(arr[right]);
                right++;
                k--;
            }
            return result;
        }
        // Time Complexity : O(log N)
        public static int findindex(int[] arr,int x,int start,int end){
            if(x<arr[start])   return start;
            if(x>arr[end])   return end;
            int mid = start+(end-start)/2;
            if(arr[mid] == x || start == end) return mid;
            if(arr[mid]>x) return findindex(arr,x,start,mid-1);
            else return findindex(arr,x,mid+1,end);
        }

    public static void main(String[] args) {
        int[] arr = {-9980,-9932,-9930,-9914,-9910,-9886,-9879,-9875,-9804,-9784,-9776,-9744,-9732,-9718,-9694,-9671,-9657,-9644,-9579,-9553,-9545,-9505,-9504,-9465,-9448,-9427,-9417,-9401,-9397,-9386,-9347,-9339,-9330,-9326,-9307,-9299,-9281,-9268,-9213,-9192,-9152,-9121,-9096,-9005,-8983,-8918,-8884,-8868,-8795,-8778,-8776,-8776,-8774,-8774,-8760,-8740,-8728,-8721,-8699,-8690,-8677,-8641,-8633,-8620,-8597,-8592,-8550,-8535,-8533,-8482,-8416,-8392,-8384,-8368,-8367,-8345,-8336,-8318,-8306,-8265,-8245,-8189,-8189,-8147,-8128,-8059,-8040,-8033,-8020,-8009,-8000,-7996,-7986,-7982,-7973,-7969,-7961,-7958,-7944,-7921,-7912,-7904,-7890,-7885,-7807,-7757,-7751,-7749,-7745,-7737,-7726,-7721,-7719,-7719,-7717,-7710,-7654,-7613,-7598,-7581,-7580,-7538,-7537,-7533,-7508,-7481,-7429,-7421,-7421,-7415,-7361,-7358,-7340,-7333,-7318,-7309,-7283,-7267,-7241,-7219,-7176,-7175,-7164,-7137,-7133,-7078,-7068,-7055,-7042,-7005,-6985,-6977,-6942,-6895,-6888,-6846,-6841,-6829,-6824,-6818,-6811,-6787,-6781,-6780,-6752,-6734,-6713,-6703,-6688,-6674,-6647,-6644,-6629,-6601,-6579,-6578,-6575,-6482,-6468,-6465,-6465,-6458,-6437,-6407,-6406,-6396,-6368,-6342,-6341,-6328,-6319,-6303,-6289,-6287,-6283,-6254,-6233,-6191,-6169,-6144,-6135,-6134,-6071,-6059,-6052,-6046,-6014,-6004,-5999,-5994,-5982,-5977,-5967,-5912,-5898,-5897,-5892,-5891,-5888,-5871,-5865,-5853,-5810,-5786,-5775,-5775,-5754,-5712,-5697,-5670,-5653,-5601,-5577,-5545,-5466,-5429,-5428,-5395,-5384,-5378,-5372,-5367,-5359,-5344,-5335,-5331,-5317,-5291,-5270,-5245,-5239,-5222,-5211,-5177,-5176,-5168,-5108,-5079,-5044,-5029,-5023,-5006,-4938,-4937,-4897,-4889,-4850,-4835,-4817,-4815,-4815,-4810,-4782,-4779,-4745,-4729,-4725,-4719,-4713,-4702,-4668,-4550,-4527,-4517,-4513,-4475,-4446,-4435,-4430,-4377,-4366,-4353,-4343,-4311,-4279,-4257,-4244,-4209,-4208,-4191,-4190,-4173,-4162,-4155,-4117,-4094,-4075,-4006,-3997,-3994,-3991,-3979,-3975,-3902,-3864,-3834,-3822,-3806,-3802,-3796,-3783,-3759,-3729,-3686,-3676,-3640,-3638,-3588,-3518,-3500,-3474,-3457,-3403,-3394,-3373,-3372,-3362,-3356,-3333,-3328,-3325,-3284,-3215,-3214,-3161,-3153,-3137,-3116,-3112,-3065,-3061,-3056,-3028,-3027,-3015,-3009,-2953,-2910,-2868,-2856,-2852,-2845,-2829,-2804,-2802,-2792,-2782,-2779,-2765,-2764,-2737,-2708,-2704,-2688,-2665,-2662,-2621,-2614,-2595,-2592,-2524,-2519,-2485,-2470,-2454,-2430,-2426,-2416,-2400,-2311,-2287,-2265,-2256,-2254,-2253,-2251,-2250,-2229,-2179,-2178,-2122,-2099,-2091,-2086,-2076,-2046,-2028,-1987,-1937,-1933,-1900,-1891,-1850,-1831,-1829,-1826,-1796,-1790,-1774,-1662,-1472,-1442,-1442,-1413,-1400,-1397,-1394,-1358,-1330,-1325,-1262,-1236,-1236,-1232,-1213,-1196,-1193,-1174,-1173,-1135,-1084,-1055,-888,-886,-858,-824,-820,-816,-811,-798,-743,-712,-698,-690,-686,-681,-673,-646,-624,-590,-551,-520,-476,-464,-443,-424,-362,-356,-354,-320,-313,-295,-229,-196,-184,-177,-175,-136,-136,-119,-111,-109,-82,-63,-50,-32,-26,-17,-13,-8,-4,-2,23,35,45,46,87,90,102,102,106,191,194,214,260,268,277,347,408,453,453,453,459,520,538,546,547,547,556,565,622,623,667,684,735,766,767,857,902,907,911,914,926,947,962,970,974,1001,1012,1033,1052,1090,1108,1108,1110,1141,1187,1189,1196,1202,1232,1251,1253,1331,1341,1370,1408,1430,1430,1434,1447,1470,1494,1505,1540,1573,1595,1598,1598,1660,1678,1731,1734,1807,1815,1817,1818,1833,1940,1958,1981,1990,1997,2003,2022,2077,2087,2098,2109,2149,2202,2211,2282,2285,2299,2304,2313,2315,2316,2327,2339,2350,2361,2377,2378,2398,2420,2434,2437,2475,2482,2501,2521,2593,2621,2642,2644,2652,2659,2671,2691,2697,2703,2706,2734,2759,2765,2792,2803,2805,2807,2833,2861,2949,2954,2969,2972,2987,3017,3020,3092,3133,3170,3193,3241,3284,3298,3301,3305,3331,3374,3379,3406,3417,3432,3444,3445,3470,3479,3502,3506,3519,3526,3556,3568,3609,3662,3690,3705,3708,3728,3731,3752,3755,3764,3825,3876,3918,3952,3956,3960,3986,4001,4030,4062,4090,4095,4171,4171,4172,4172,4189,4189,4198,4221,4222,4228,4229,4253,4272,4283,4286,4286,4312,4327,4354,4400,4427,4432,4474,4494,4515,4517,4541,4561,4572,4584,4624,4634,4649,4660,4716,4718,4723,4810,4810,4814,4871,4903,4911,4923,4942,4946,4977,5022,5025,5030,5068,5088,5093,5153,5159,5179,5202,5210,5244,5319,5373,5468,5479,5481,5484,5488,5488,5488,5499,5502,5527,5534,5541,5564,5582,5622,5664,5675,5706,5719,5733,5735,5747,5759,5782,5837,5841,5842,5921,6011,6013,6034,6047,6075,6096,6102,6110,6120,6124,6132,6165,6178,6182,6196,6205,6260,6267,6267,6275,6291,6293,6302,6304,6336,6350,6383,6389,6404,6421,6456,6474,6502,6505,6514,6616,6685,6693,6736,6764,6794,6816,6817,6822,6822,6828,6867,6879,6882,6889,6897,6909,6925,6939,6945,6986,7002,7008,7009,7010,7061,7075,7083,7139,7152,7152,7162,7231,7264,7286,7287,7334,7335,7386,7404,7404,7439,7451,7474,7480,7485,7520,7539,7546,7555,7584,7596,7619,7664,7703,7708,7728,7740,7742,7751,7792,7794,7798,7801,7857,7864,7896,7904,7920,7927,7941,7945,7947,7952,7952,7974,7982,7982,7983,7996,7999,8007,8016,8028,8040,8043,8076,8082,8109,8114,8117,8142,8166,8173,8192,8239,8240,8251,8259,8267,8346,8353,8398,8448,8493,8503,8509,8530,8538,8635,8649,8693,8720,8721,8737,8744,8763,8766,8781,8785,8795,8818,8824,8853,8870,8884,8892,8902,8912,8950,8958,9005,9006,9011,9048,9094,9119,9174,9181,9242,9260,9269,9285,9289,9295,9296,9307,9350,9360,9371,9382,9392,9399,9410,9446,9464,9481,9482,9500,9502,9504,9524,9534,9537,9542,9543,9583,9586,9597,9626,9660,9677,9680,9687,9735,9763,9765,9768,9783,9784,9836,9840,9862,9865,9916,9923,9927,9934,9988};
        int k = 391;
        int x = 2457;
        List<Integer> output = findClosestElements(arr,k,x);
    }
}
