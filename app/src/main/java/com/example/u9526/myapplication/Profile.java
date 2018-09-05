package com.example.leezheng.newangel.fragment;

import android.app.Activity;
import android.app.ActivityOptions;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.leezheng.newangel.LoginActivity;
import com.example.leezheng.newangel.MainActivity;
import com.example.leezheng.newangel.R;
import com.example.leezheng.newangel.helper.Repeatlogin;
import com.example.leezheng.newangel.pair_angel.Activity_angel_pair;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

import static android.app.AlertDialog.THEME_HOLO_LIGHT;


public class Profile extends Fragment {
    private View v;
    private ImageView profile_user_img;
    private ImageButton profile_user_camera, profile_user_class1_button, profile_user_class2_button;
    private TextView profile_user_sex, profile_user_name, profile_user_major, profile_user_birth, profile_user_emotional_status, profile_user_hobby, profile_user_club, profile_user_favorite_class, profile_user_favorite_city, profile_user_confusion, profile_user_talent, profile_user_dream;
    private int GALLERY = 1, CAMERA = 2;
    //--------------------------------------------------------------------------------------------------彈入layout所使用之宣告
    private TextView title1, title2, title3;
    private CardView cardview1, cardview2, cardview3;
    private Animation uptodown, downtoup, righttoleft;//彈入layout使用
    //--------------------------------------------------------------------------------------------------
    private SharedPreferences user_data;//寫入手機的
    //----------------------------------------------------------------------------------------------宣告所有的使用者欄位資訊
    private int userid, sex, birth_month, birth_date, birth_status;
    private String image, token, major, name, emotional_status, hobby, club, favorite_class, favorite_city, confusion, talent, dream, imageFromLocal;
    //----------------------------------------------------------------------------------------------宣告所有的使用者欄位資訊
    // ---------------------- 上傳照片變數宣告
    private Bitmap FixBitmap;
    private Bitmap bmp;
    Uri imgUri, url;
    String fname, ConvertImage;
    String GetImageDataFromEditText, encoded_string;
    BitmapFactory.Options option;
    ByteArrayOutputStream byteArrayOutputStream;
    byte[] byteArray;
    ProgressDialog progressDialog;

    HttpURLConnection httpURLConnection;
    OutputStream outputStream;
    BufferedWriter bufferedWriter;
    BufferedReader bufferedReader;
    StringBuilder stringBuilder;
    int RC;
    boolean check = true;
    // ---------------------- 上傳照片變數宣告

    public Profile() {
        // Required empty public constructor
    }

    public static Profile newInstance() {
        Profile fragment = new Profile();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_profile, container, false);//產生layout畫面

        readData();//-------------------------------------------------------------------------------讀取SharedPreference裡面所有資料
        show_net_work();//--------------------------------------------------------------------------檢查網路是否正常運作&&檢查帳號是否重複登入(須放在readData後面)
        AlertDialog fragment_profile_alert_dialog = new AlertDialog.Builder(getActivity(), R.layout.fragment_profile_alert_dialog).create();//宣告 AlertDialog 用來彈跳視窗  編輯使用者資訊
//--------------------------------------------------------------------------------------------------彈入視窗所用到layout
        title1 = (TextView) v.findViewById(R.id.title1);
        title2 = (TextView) v.findViewById(R.id.title2);
        title3 = (TextView) v.findViewById(R.id.title3);
        cardview1 = (CardView) v.findViewById(R.id.cardview1);
        cardview2 = (CardView) v.findViewById(R.id.cardview2);
        cardview3 = (CardView) v.findViewById(R.id.cardview3);
//--------------------------------------------------------------------------------------------------彈入視窗事件
        uptodown = AnimationUtils.loadAnimation(getActivity(), R.anim.uptodown);//宣告上至下function
        downtoup = AnimationUtils.loadAnimation(getActivity(), R.anim.downtoup);//宣告下至上function
        righttoleft = AnimationUtils.loadAnimation(getActivity(), R.anim.righttoleft);//宣告右邊至左邊function

        cardview1.setAnimation(uptodown);//上段內文 由上至下
        title1.setAnimation(uptodown);//上段標題 由上至下

        cardview2.setAnimation(righttoleft);//內文右至左
        title2.setAnimation(righttoleft);//標題右至左

        cardview3.setAnimation(downtoup);//下段內文 由下至上
        title3.setAnimation(downtoup);//下段標題 由下至上
//--------------------------------------------------------------------------------------------------彈入視窗事件
//--------------------------------------------------------------------------------------------------所有的顯示宣告

        profile_user_sex = (TextView) v.findViewById(R.id.profile_user_sex);

        profile_user_name = (TextView) v.findViewById(R.id.profile_user_name);
        profile_user_major = (TextView) v.findViewById(R.id.profile_user_major);

        profile_user_birth = (TextView) v.findViewById(R.id.profile_user_birth);//生日
        profile_user_emotional_status = (TextView) v.findViewById(R.id.profile_user_emotional_status);//感情狀態
        profile_user_hobby = (TextView) v.findViewById(R.id.profile_user_hobby);//我的興趣
        profile_user_club = (TextView) v.findViewById(R.id.profile_user_club);//參加的社團
        profile_user_favorite_class = (TextView) v.findViewById(R.id.profile_user_favorite_class);//喜歡的課程
        profile_user_favorite_city = (TextView) v.findViewById(R.id.profile_user_favorite_city);//喜歡的城市


        profile_user_confusion = (TextView) v.findViewById(R.id.profile_user_confusion);//最近的困惑
        profile_user_talent = (TextView) v.findViewById(R.id.profile_user_talent);//可交換的才藝
        profile_user_dream = (TextView) v.findViewById(R.id.profile_user_dream);//我的夢想

//--------------------------------------------------------------------------------------------------帶入使用者資料
        profile_user_name.setText(name);
        profile_user_major.setText(major);

        birth_check();//生日判斷

        profile_user_emotional_status.setText(emotional_status);

        profile_user_hobby.setText(hobby);
        profile_user_club.setText(club);
        profile_user_favorite_class.setText(favorite_class);
        profile_user_favorite_city.setText(favorite_city);

        profile_user_confusion.setText(confusion);
        profile_user_talent.setText(talent);
        profile_user_dream.setText(dream);
//--------------------------------------------------------------------------------------------------帶入使用者資料


//--------------------------------------------------------------------------------------------------圓框大頭照

        profile_user_img = (ImageView) v.findViewById(R.id.profile_user_img); // 圓框大頭照

//--------------------------------------------------------------------------------------------------宣告所有的按鈕
        profile_user_camera = (ImageButton) v.findViewById(R.id.profile_user_camera);//大頭照按鈕

        profile_user_class1_button = (ImageButton) v.findViewById(R.id.profile_user_class1_button);//第一分類按鈕

        profile_user_class2_button = (ImageButton) v.findViewById(R.id.profile_user_class2_button);//第二分類按鈕
        default_user_image();//初始化照片 有照片轉乘base64
        //base64_to_image();  //傳入 base64 轉成 image，並顯示再imageView上

// -------------------------------------------------------------------------------------------------
        profile_user_camera_click();//開啟相片選擇dialog

        profile_user_class1_button_click();

        profile_user_class2_button_click();

        sex_check();//選擇 男同學 女同學

        System.out.println("!image = " + image);
//--------------------------------------------------------------------------------------------------宣告所有的按鈕
        return v;
    }

    //--------------------------------------------------------------------------------------------------拍照完會執行 onActivityResult 函式
//--------------------------------------------------------------------------------------------------彈出選擇照片的dialog
    private void profile_user_camera_click() {
        profile_user_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPictureDialog();
            }
        });
    }

    // -------------------------------------------------------------------------------------------------開啟相簿 or 開相機 事件
    private void showPictureDialog() {
        android.support.v7.app.AlertDialog.Builder pictureDialog = new android.support.v7.app.AlertDialog.Builder(getActivity());
        pictureDialog.setTitle("Select Action");
        String[] pictureDialogItems = {
                "選擇照片",
                "相機"
        };
        pictureDialog.setItems(pictureDialogItems,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                choosePhotoFromGallary();
                                break;

                            case 1:
                                takePhotoFromCamera();
                                break;
                        }
                    }
                });
        pictureDialog.show();
    }

// -------------------------------------------------------------------------------------------------是否上傳事件

    // ################################################################################################# 開相簿事件
    public void choosePhotoFromGallary() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        startActivityForResult(galleryIntent, GALLERY);
    }

    // ---------------------------------------------------------------------------------------------開啟相機事件
    private void takePhotoFromCamera() {
        Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);  // ACTION_IMAGE_CAPTURE 為開啟相機的內建參數名稱
        startActivityForResult(intent, CAMERA);
    }
    //開相簿 或 拍照完後會執行 onActivityResult 函式

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == getActivity().RESULT_CANCELED) {
            return;
        }
        if (requestCode == GALLERY) {
            if (data != null) {
                Uri contentURI = data.getData();
                try {
                    //取得系統的公用圖檔路徑
                    /*
                    String dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).toString();


                    fname = "p" + System.currentTimeMillis() + ".jpg";  // 利用目前時間組合出一個不會重複的檔名
                    imgUri = Uri.parse("file://" + dir + "/" + fname); // 依fname的路徑及檔名建立 Uri 物件
                    option = new BitmapFactory.Options();   // 建立選項物件
                    option.inJustDecodeBounds = true; //設定選項：只讀取圖檔資訊而不載入圖檔
                    bmp = BitmapFactory.decodeFile(imgUri.getPath(),option);  //載入圖檔
                    */
                    //  BitmapFactory.decodeFile(imgUri.getPath(),option); //讀取圖檔資訊存入 Option 中

                    // 從相簿端將照片萃取出來，放到FixBitmap
                    FixBitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), contentURI);
                    FixBitmap = ImageCompressL(FixBitmap);
                    // String path = saveImage(bitmap);
                    Toast.makeText(getActivity(), "圖片已儲存!", Toast.LENGTH_SHORT).show();

                    // 將圖片顯示在圓框上
                    //Picasso.get().load(pair_image).into(profile_user_img);
                    profile_user_img.setImageBitmap(FixBitmap);
                    // 上傳照片至資料庫

                    UploadImageToServer();


                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(getActivity(), "Failed!", Toast.LENGTH_SHORT).show();
                }
            }

        } else if (requestCode == CAMERA) {
            FixBitmap = (Bitmap) data.getExtras().get("data");
            FixBitmap = ImageCompressL(FixBitmap);
            profile_user_img.setImageBitmap(FixBitmap);
            // 設為系統共享媒體檔
            //Intent it = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, imgUri);
            //getActivity().sendBroadcast(it);
            //UploadImageOnServerButton.setVisibility(View.VISIBLE);
            //  saveImage(thumbnail);
            Toast.makeText(getActivity(), "圖片已儲存!", Toast.LENGTH_SHORT).show();

            UploadImageToServer();
        }

    }

    // -------------------------------------------------------------------------------------------------將照片上傳至資料庫
    public void UploadImageToServer() {

        ConvertImage = getStringImage(FixBitmap);

        saveData(ConvertImage);


        class AsyncTaskUploadClass extends AsyncTask<Void, Void, String> {

            // 1. onPreExecute－之前
            // 在背景工作執行之前會自動執行的方法，開發人員可覆寫onPreExecute，在方法內撰寫程式碼。

            // 2. onProgressUpdate－過程
            // 在下載過程中可以手動呼叫的方法，在doInBackground中呼叫「publishProgress方法」會自動執行onProgressUpdate方法內的程式碼。

            //3. onPostExecute－之後
            // 在背景工作執行完成後會自動執行的方法，執行完的結果 - Result 會傳入這裡。

            @Override
            protected String doInBackground(Void... params) {

                ImageProcessClass imageProcessClass = new ImageProcessClass();
                HashMap<String, String> HashMapParams = new HashMap<String, String>();

                HashMapParams.put("userid", Integer.toString(userid));
                HashMapParams.put("token", token);
                HashMapParams.put("image_data", ConvertImage);


                String FinalData = imageProcessClass.ImageHttpRequest("http://140.136.133.78/angel_pair/Activity_image/UploadImg.php", HashMapParams);
                return FinalData;
            }
        }
        AsyncTaskUploadClass AsyncTaskUploadClassOBJ = new AsyncTaskUploadClass();
        AsyncTaskUploadClassOBJ.execute();
    }

    // 將Bitmap 轉成 string
    public String getStringImage(Bitmap bmp) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 50, baos);
        byte[] array = baos.toByteArray();
        encoded_string = Base64.encodeToString(array, 0);
        return encoded_string;
    }

    // 計算Bitmap大小，如果超過256kb，則進行壓縮
    private Bitmap ImageCompressL(Bitmap bitmap) {
        double targetwidth = Math.sqrt(256.00 * 1000);
        if (bitmap.getWidth() > targetwidth || bitmap.getHeight() > targetwidth) {
            // 創建操作圖片用的matrix對象
            Matrix matrix = new Matrix();
            // 計算高寬縮放率
            double x = Math.max(targetwidth / bitmap.getWidth(), targetwidth
                    / bitmap.getHeight());
            // 縮放圖片動作
            matrix.postScale((float) x, (float) x);
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(),
                    bitmap.getHeight(), matrix, true);

        }
        return bitmap;
    }


    public class ImageProcessClass {
        public String ImageHttpRequest(String requestURL, HashMap<String, String> PData) {
            StringBuilder stringBuilder = new StringBuilder();
            try {
                URL url = new URL(requestURL);
                httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setReadTimeout(20000);
                httpURLConnection.setConnectTimeout(20000);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                outputStream = httpURLConnection.getOutputStream();

                bufferedWriter = new BufferedWriter(
                        new OutputStreamWriter(outputStream, "UTF-8"));

                bufferedWriter.write(bufferedWriterDataFN(PData));
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                RC = httpURLConnection.getResponseCode();
                if (RC == HttpsURLConnection.HTTP_OK) {
                    bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                    stringBuilder = new StringBuilder();
                    String RC2;
                    while ((RC2 = bufferedReader.readLine()) != null) {
                        stringBuilder.append(RC2);
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            return stringBuilder.toString();
        }

        private String bufferedWriterDataFN(HashMap<String, String> HashMapParams) throws UnsupportedEncodingException {
            stringBuilder = new StringBuilder();
            for (Map.Entry<String, String> KEY : HashMapParams.entrySet()) {
                if (check)
                    check = false;
                else
                    stringBuilder.append("&");

                stringBuilder.append(URLEncoder.encode(KEY.getKey(), "UTF-8"));

                stringBuilder.append("=");

                stringBuilder.append(URLEncoder.encode(KEY.getValue(), "UTF-8"));
            }

            return stringBuilder.toString();
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 5) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Now user should be able to use camera

            } else {

                Toast.makeText(getActivity(), "Unable to use Camera..Please Allow us to use Camera", Toast.LENGTH_LONG).show();

            }
        }
    }

    private Bitmap base64_to_image() {
        // 把 資料庫傳來的 Base64 傳成 byte[]
        byte[] decodedString = Base64.decode(image, Base64.DEFAULT);
        // 把 byte[] 解碼成 Bitmap
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
        // 顯示在ImageView上
        profile_user_img.setImageBitmap(decodedByte);
        return decodedByte;
    }

    // #################################################################################################
    //--------------------------------------------------------------------------------------------------第一分類按鈕事件
    private void profile_user_class1_button_click() {


        profile_user_class1_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ProfileFragment_class1_edit.class);
                Bundle bndlanimation = ActivityOptions.makeCustomAnimation(getActivity().getApplicationContext(), R.anim.animation, R.anim.animation2).toBundle();
                startActivity(intent, bndlanimation);
                getActivity().finish();
            }
        });
    }

    //--------------------------------------------------------------------------------------------------第二分類按鈕事件
    private void profile_user_class2_button_click() {


        profile_user_class2_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ProfileFragment_class1_edit.class);
                Bundle bndlanimation = ActivityOptions.makeCustomAnimation(getActivity().getApplicationContext(), R.anim.animation, R.anim.animation2).toBundle();
                startActivity(intent, bndlanimation);
                getActivity().finish();
            }
        });
    }

    //--------------------------------------------------------------------------------------------------sex choice
    private void sex_check() {
        if (sex != 0) {
            profile_user_sex.setText("男同學");
        } else {
            profile_user_sex.setText("女同學");
        }
    }


    //--------------------------------------------------------------------------------------------------saveSharedPreferences
    public void saveData(String IMAGE_BASE64) {
        user_data = this.getActivity().getSharedPreferences("USER_DATA", 0);
        user_data.edit()
                .putString("IMAGE_BASE64", IMAGE_BASE64)
                .commit();
    }

    //--------------------------------------------------------------------------------------------------讀取資料
    public void readData() {
        SharedPreferences user_data = this.getActivity().getSharedPreferences("USER_DATA", 0);
        image = (user_data.getString("IMAGE", ""));
        token = (user_data.getString("TOKEN", ""));
        birth_status = (user_data.getInt("BIRTH_STATUS", 0));
        userid = (user_data.getInt("USERID", 0));
        name = (user_data.getString("NAME", ""));
        major = (user_data.getString("MAJOR", ""));
        sex = (user_data.getInt("SEX", 0));
        //----------------------------------------------------------------------------------------------class1
        birth_month = (user_data.getInt("BIRTH_MONTH", 0));
        birth_date = (user_data.getInt("BIRTH_DATE", 0));
        emotional_status = (user_data.getString("EMOTIONAL_STATUS", ""));
        hobby = (user_data.getString("HOBBY", ""));
        club = (user_data.getString("CLUB", ""));
        favorite_class = (user_data.getString("FAVORITE_CLASS", ""));
        favorite_city = (user_data.getString("FAVORITE_CITY", ""));

        confusion = (user_data.getString("CONFUSION", ""));
        talent = (user_data.getString("TALENT", ""));
        dream = (user_data.getString("DREAM", ""));
        imageFromLocal = (user_data.getString("IMAGE_BASE64", ""));


    }

    //--------------------------------------------------------------------------------------------------DeleteSharedPreferencesData
    public void Delete_Data() {
        user_data = getActivity().getSharedPreferences("USER_DATA", 0);
        user_data.edit()
                .putInt("PAIR_LORD_STATUS", 0)
                .putInt("PAIR_ANGEL_STATUS", 0)
                .putString("USER_COUNT", "")
                .putString("IMAGE", "")
                .putString("TOKEN", "")
                .putInt("USERID", 0)
                .putString("NAME", "")
                .putString("MAJOR", "")
                // .putInt("SEX",0)

                .putInt("BIRTH_MONTH", 0)
                .putInt("BIRTH_DATE", 0)
                .putString("EMOTIONAL_STATUS", "")
                .putString("HOBBY", "")
                .putString("CLUB", "")
                .putString("FAVORITE_CLASS", "")
                .putString("FAVORITE_CITY", "")

                .putString("CONFUSION", "")
                .putString("TALENT", "")
                .putString("DREAM", "")


                .commit();//寫入
    }

    //--------------------------------------------------------------------------------------------------判斷使用者生日
    private void birth_check() {
        if (birth_month == 0 || birth_date == 0) {
            profile_user_birth.setText("未填");

        } else {
            profile_user_birth.setText(birth_month + "月" + birth_date + "日");
        }
    }

    //##################################################################################################檢查網路是否正常運作
    private void show_net_work() {
        ConnectivityManager cwjManager = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cwjManager.getActiveNetworkInfo();
        if (info != null && info.isAvailable()) {
            repeat_login();//-----------------------------------------------------------------------檢查帳號是否重複登入
        } else {
            repeat_netcut_dialog();
        }
    }

    //--------------------------------------------------------------------------------------------------斷網顯示
    private void repeat_netcut_dialog() {
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        final View v = inflater.inflate(R.layout.repeat_net_alert_dialog, null);
        //樣式: THEME_HOLO_LIGHT   THEME_HOLO_DARK  THEME_TRADITIONAL   THEME_DEVICE_DEFAULT_DARK  THEME_DEVICE_DEFAULT_LIGHT
        new AlertDialog.Builder(getActivity(), THEME_HOLO_LIGHT)
                .setTitle("警告")
                .setView(v)
                .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .show();
    }
    //-------------------------------------------------------------------------------------------------重複登入顯示
    /*
    protected void repeat_login() {
        class AsyncTaskMain extends AsyncTask<Void,Void,String> {

            @Override
            protected String doInBackground(Void... voids) {
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if (success) {
                                repeat_login_dialog();
                            } else {
                                //繼續使用
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                Repeatlogin repeatlogin = new Repeatlogin(String.valueOf(userid),token, responseListener);
                RequestQueue queue = Volley.newRequestQueue(getActivity());
                queue.add(repeatlogin);

                return null;
            }
        }
        AsyncTaskMain AsyncTaskUploadClassOBJ = new AsyncTaskMain();
        AsyncTaskUploadClassOBJ.execute();
    }
    //--------------------------------------------------------------------------------------------------重複登入alert

    private void repeat_login_dialog(){
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        final View v = inflater.inflate(R.layout.repeat_login_alert_dialog, null);
        //樣式: THEME_HOLO_LIGHT   THEME_HOLO_DARK  THEME_TRADITIONAL   THEME_DEVICE_DEFAULT_DARK  THEME_DEVICE_DEFAULT_LIGHT
        new AlertDialog.Builder(getActivity(),THEME_HOLO_LIGHT)

                .setTitle("警告")
                .setView(v)
                .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(getContext(), LoginActivity.class);
                        Bundle bndlanimation = ActivityOptions.makeCustomAnimation(getActivity().getApplicationContext(), R.anim.animation_up,R.anim.animation_up2).toBundle();
                        startActivity(intent, bndlanimation);
                        Delete_Data();//
                        getActivity().finish();
                    }
                })
                .show();


    }
    */

    private Bitmap base64_to_bitmap(String my_base64) {
        // 把 資料庫傳來的 Base64 傳成 byte[]
        byte[] decodedString = Base64.decode(my_base64, Base64.DEFAULT);
        // 把 byte[] 解碼成 Bitmap
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
        // 顯示在ImageView上
        //profile_user_img.setImageBitmap(decodedByte);
        return decodedByte;
    }

    //##################################################################################################
    private void default_user_image() {
        // imageFromLocal 本地上傳的照片一定是最新，要優先判斷(因為不是每次Loading這頁都和資料庫拿圖片)
        if (imageFromLocal != "") {
            profile_user_img.setImageBitmap(base64_to_bitmap(imageFromLocal));

        } //再來判斷preference 是否有圖片
        else if (image != "") {
            Picasso.get().load(image).into(profile_user_img);
            // 到這層代表 兩者皆為空，設為預設圖片
        } else {
            profile_user_img.setImageResource(R.mipmap.fragment_profile_user_img);
        }
    }
}
