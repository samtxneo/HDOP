package com.example.a100daysofpushup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.arch.core.internal.SafeIterableMap;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.Api;
import com.example.a100daysofpushup.leaderboard.LeaderboardActivity;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.util.Log;
import android.widget.TextView;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "GoogleSignIn";
    private Button viewLeaderboardButton;
    final Map<String, ArrayList<String>> dataMap = new HashMap<String, ArrayList<String>>();
 private static final int RC_SIGN_IN = 9001;
 private GoogleSignInClient mGoogleSignInClient;
 private static final String SCRIPT_URL = "YOUR_WEB_APP_URL_HERE"; // Replace with your Apps Script web app URL
 private SignInButton signInButton;
    String[] day1 = new String[]{"1", "5 Push ups + 1 minute plank", "Embrace the challenge"};
    String[] day2 = new String[]{"2", "6 Push ups minimum + 1 minute plank", "It has been a fantastic start!"};
    String[] day3 = new String[]{"3", "7 Push ups minimum + 1 minute plank", "it is easy to give you a chart and say do your pushups as per this. That is not our purpose. The idea is to interact with each other, send you the message and talk with you and motivate each other! Yes, we are in this challenge together!"};
    String[] day4 = new String[]{"4", "7 Push ups minimum + 1 minute plank", "Every one is filling in the daily counts. Amazing to see your numbers. "};
    String[] day5 = new String[]{"5", "5 Push ups + 1 minute plank + 5 Push ups", "Ok to take breaks, your breaks will reduce. Start slow. don't over do, keep doing for all 100 days."};
    String[] day6 = new String[]{"6", "5 Push ups + 1 minute plank + 5 Push ups ", "We are building a new habit, it is going to take time! We will do it."};
    String[] day7 = new String[]{"7", "5 Push ups + 1 minute plank + 5 Push ups", "We are in this for a long time. The mental strength is the hardest to build and it is not built in a day!"};
    String[] day8 = new String[]{"8", "5 Push ups + 1 minute plank (one easy day)", "It's 100 days challange, slow and stedy wins the race!"};
    String[] day9 = new String[]{"9", "6 Push ups + 1 minute plank + 6 Push ups", "We are building mental strength! it's not easy to do the same workout for 100 days!"};
    String[] day10 = new String[]{"10", "45 sec Plank + 6 Push ups + 45 sec Plank + 6 Push ups + 45 sec Plank", "The planks are to help build your strength for doing the pushups for 100 days."};
    String[] day11 = new String[]{"11", "45 sec Plank + 6 Push ups + 45 sec Plank + 6 Push ups + 45 sec Plank", "It's 100 days challange, slow and stedy wins the race!"};
    String[] day12 = new String[]{"12", "45 sec Plank + 6 Push ups + 45 sec Plank + 6 Push ups + 45 sec Plank", "We are not recording the planks in our daily sheet because we are only measuing ourself with one parameter that is push ups."};
    String[] day13 = new String[]{"13", "30 sec Plank + 7 Push ups + 30 sec Plank + 7 Push ups + 45 sec Plank", "It is time to get our lives on track. Limit the screen time and become productive"};
    String[] day14 = new String[]{"14", "5 Push ups + 1 min Plank", "we are not perfect yet"};
    String[] day15 = new String[]{"15", "10 Push ups + 1 min Plank + 10 Push ups", "Let us get into the weekend with some extra push!"};
    String[] day16 = new String[]{"16", "10 Push ups + 1 min Plank + 10 Push ups", "You are really successfull if at least one of your family member joins you in the pushups!!"};
    String[] day17 = new String[]{"17", "10 Push ups + 30 sec Plank + 10 Push ups + 30 sec Plank + 5 Push ups", "The hard part is keep doing for 100 days without skiping! Any ideas for motivating everyone?"};
    String[] day18 = new String[]{"18", "10 Push ups + 30 sec Plank + 10 Push ups + 30 sec Plank + 5 Push ups", "Doing fewer pushups in good form is better than too many pushups in bad form"};
    String[] day19 = new String[]{"19", "14 Pushups + 1 min Plank + 14 Pushups", "Can you almost touch your chest to the ground?"};
    String[] day20 = new String[]{"20", "10 Pushups + 30 sec plank + 10 Pushups + 30 sec plank + 10 Pushups", "How do you motivate yourself? Workout every day is hard."};
    String[] day21 = new String[]{"21", "10 Pushups + 1 min Plank + 10 Pushups", "Here we have one easy day. Keep at it, you can do it, we have just started, we will do it for 100 days!"};
    String[] day22 = new String[]{"22", "15 Pushups + 30 sec plank + 15 Pushups + 30 sec plank + 4 Pushups", "All the people interested in health and fitness that I have met are always caring people towards the environment, have you noticed it too?"};
    String[] day23 = new String[]{"23", "15 Pushups + 30 sec plank + 15 Pushups + 30 sec plank + 7 Pushups", "There is a thin line between doing too much and less than what is required, you may have to explore your limit, remeber we are in for all 100 days, it is a long journey to make us loose all our fear of push ups."};
    String[] day24 = new String[]{"24", "20 Pushups + 1 min plank + 20 Pushups", "It may be a bit challenging for the first time people. It is ok, let us push ourself a bit!"};
    String[] day25 = new String[]{"25", "20 Pushups + 20 sec plank + 20 Pushups + 30 sec plank + 4 Pushups+5 Squats", "Yes we can do 20 pushups in one set!"};
    String[] day26 = new String[]{"26", "22 Pushups + 30 sec plank + 22 Pushups + 30 sec plank + 3 Pushups+5 Squats", "Yes it increased! give it your best try and push yourself, it does not take long!"};
    String[] day27 = new String[]{"27", "15 Pushups + 30 sec plank + 15 Pushups + 30 sec plank + 4 Pushups+5 Squats", "Now 15 pushups in one set is our easy day :)"};
    String[] day28 = new String[]{"28", "20 Pushups + 30 sec plank + 20 Pushups + 30 sec plank + 10 Pushups+5 Squats", "Last few days before the count will drop again."};
    String[] day29 = new String[]{"29", "20 push ups + 20 sec plank + 20 push ups + 30 sec plank + 10 push ups+5 Squats", "Just give it your best try!We are almost finishing one month of doing push ups, has it become a habit for you?"};
    String[] day30 = new String[]{"30", "25 push ups + 1 min plank + 25 push ups+5 Squats", "This may be hardest day so far. This is the last day we will be doing so many push ups in one set! From tomorrow we will go down in number of push ups. Do try your best to do the 25 push ups but if it is difficult for you don't worry too much but do try your best!"};
    String[] day31 = new String[]{"31", "10 push ups + 1 min plank + 10 push ups + 1 min plank +  5 push ups+5 Squats", "Martina Navratilova was asked: How do you maintain your focus, physique and sharp game even at the age of 43?  She gave a humble reply: The ball doesnâ€™t know how old I am.  You need to stop yourself from stopping yourself.  Performance is potential minus internal interference."};
    String[] day32 = new String[]{"32", "10 push ups + 30 sec plank + 10 push ups + 30 sec plank + 10 pushups + 30 sec plank + 5 push ups+5 Squats", "Just check now there are 4 sets of pushups"};
    String[] day33 = new String[]{"33", "14 Push ups + 1 min Plank + 14 Push ups + 1 min Plank + 14 Push ups+5 Squats", "Now 14 push ups in one set is not a big deal, is it?"};
    String[] day34 = new String[]{"34", "10 Push ups + 30 sec plank + 10 Push ups + 30 sec plank + 10 Push ups + 30 sec plank + 10 Push ups+5 Squats", "Remember it is 4 sets!"};
    String[] day35 = new String[]{"35", "15 Push ups + 1 min Plank + 15 Push ups + 1 min Plank + 15 Push ups+5 Squats", "Doing push ups daily should be a habit now, make it a routine,"};
    String[] day36 = new String[]{"36", "15 Push ups + 30 sec plank + 15 Push ups + 30 sec plank + 15 Push ups + 30 sec plank + 7 Push ups+7 Squats", "After over a month of continues push ups workout fatigue builds up in your muscles. It is very important that you do a 5 min warm-up before the workout and about 5 to 7 min of stretching workout after"};
    String[] day37 = new String[]{"37", "20 Push ups + 1 min plank + 20 Push ups + 1 min plank + 20 Push ups+7 Squats", "After the first month is is difficult to continue. Now your determination is required."};
    String[] day38 = new String[]{"38", "20 Push ups + 20 sec plank + 20 Push ups + 30 sec plank + 20 Push ups + 20 sec plank + 4 Push ups+7 Squats", "There are 4 sets of pushups!!"};
    String[] day39 = new String[]{"39", "22 Push ups + 30 sec plank + 22 Push ups + 30 sec plank + 22 Push ups + 30 sec plank + 3 Pushups+7 Squats", "We have done this before, 22 push ups in one set is not easy but it is doable. push hard! You can do it! Difficult but not impossible! you know later the count will go down! Hang in there! Do the warm up and stretching!"};
    String[] day40 = new String[]{"40", "15 Push ups + 30 sec plank + 15 Push ups + 30 sec plank + 15 Push ups + 30 sec plank + 4 Push ups+7 Squats", "Here is an easy day for you! Enjoy :)"};
    String[] day41 = new String[]{"41", "20 Push ups + 30 sec plank + 20 Push ups + 30 sec plank + 20 Push ups + 30 sec plank + 10 Push ups+7 Squats", "4 Sets!!!!"};
    String[] day42 = new String[]{"42", "20 Push ups + 30 sec plank + 20 Push ups + 30 sec plank + 20 Push ups + 30 sec plank + 10 Push ups+7 Squats", "4 sets and 20 push ups in a set is not easy but think about it, this routine hardly takes any time, I know 1 min plan feels like half an hour."};
    String[] day43 = new String[]{"43", "20 Push ups + 30 sec plank + 20 Push ups + 30 sec plank + 20 Push ups + 30 sec plank + 10 Push ups+7 Squats", "Yes just 2 days of large sets then we again go down in number of push ups per set! Promise!"};
    String[] day44 = new String[]{"44", "25 Push ups + 1 min Plank + 25 Push ups  + 1 min Plank + 25 Push ups+7 Squats", "Today is the last hard day with 25 push ups in one set,"};
    String[] day45 = new String[]{"45", "10 push ups + 1 min plank + 10 push ups + 1 min plank +  10 push ups + 1 min plank +  5 push ups+7 Squats", "Now it is easy :)"};
    String[] day46 = new String[]{"46", "14 Push ups + 1 min Plank + 14 Push ups + 1 min Plank + 14 Push ups+10 Squats", "Yes we continue with our easy push up sets not too many in one go, we are getting some rest to ramp up again."};
    String[] day47 = new String[]{"47", "10 Push ups + 30 sec plank + 10 Push ups + 30 sec plank + 10 Push ups+ 30 sec plank + 10 Push ups+10 Squats", "Another easy set day!"};
    String[] day48 = new String[]{"48", "15 Push ups + 1 min Plank + 15 Push ups + 1 min Plank + 15 Push ups+10 Squats", "Think about your workout with a positive attitude. don't make it a work that needs to be finished."};
    String[] day49 = new String[]{"49", "10 Push ups + 1 min Plank + 10 Push ups + 1 min Plank + 10 Push ups+10 Squats", "You might think we got up to 25 push ups in one set now why are going down? When you do hard workout you take a little load off and let your strength build up before overloading again."};
    String[] day50 = new String[]{"50", "15 Push ups + 30 sec plank + 15 Push ups + 30 sec plank  + 15 Push ups + 30 sec plank + 4 Push ups+10 Squats", "If you have been doing lots more than the count you get then keep doing what you are doing. Just be careful if you get any aches or pains do not hesitate to come down to the lower number of pushups"};
    String[] day51 = new String[]{"51", "15 Push ups + 30 sec plank + 15 Push ups + 30 sec plank + 15 Push ups + 30 sec plank + 7 Push ups+10 Squats", "Keep doing! We are at the midpoint of our committed 100 days! Let us stay together and let us finish it! Keep strong!"};
    String[] day52 = new String[]{"52", "20 Push ups + 1 min plank + 20 Push ups + 1 min plank + 20 Push ups+10 Squats", "Guys, think positively about your workout!"};
    String[] day53 = new String[]{"53", " 20 Push ups + 20 sec plank + 20 Push ups + 30 sec plank + 20 Push ups + 30 sec plank + 4 Push ups+10 Squats", "It is not difficult to do lots of push ups. The difficult part is doing more push ups in one set with the perfect form. We have stayed on for so long let us not give up. Let us make it happen!"};
    String[] day54 = new String[]{"54", " 22 Push ups + 30 sec plank + 22 Push ups + 30 sec plank + 22 Push ups + 30 sec plank + 3 Push ups+10 Squats", "You are familiar with the buildup by now. Yes we are building up to one more set of 25 push ups. Yes we can do it! I know it can be a hard task to finish but remember it hardly takes any time to finish."};
    String[] day55 = new String[]{"55", "15 Push ups + 30 sec plank + 15 Push ups + 30 sec plank  + 15 Push ups + 30 sec plank + 4 Push ups+10 Squats", "Give yourself a purpose to keep on going,"};
    String[] day56 = new String[]{"56", " 20 Push ups + 30 sec plank + 20 Push ups + 30 sec plank + 20 Push ups + 30 sec plank + 10 Push ups+15 Squats", "4 Sets"};
    String[] day57 = new String[]{"57", " 20 Push ups + 30 sec plank + 20 Push ups + 30 sec plank + 20 Push ups + 30 sec plank + 10 Push ups+15 Squats", "4 Sets"};
    String[] day58 = new String[]{"58", "25 Push ups + 1 min Plank + 25 Push ups + 1 min Plank + 25 Push ups+15 Squats", "It's our challenge day again! Yes 25 push ups in one set then the number goes down again, you know how it works! Let us give it all!"};
    String[] day59 = new String[]{"59", "10 push ups + 1 min plank + 10 push ups + 1 min plank + 10 push ups + 1 min plank +  5 push ups+15 Squats", "use these low repetition days tom improve your push up form and do them slo"};
    String[] day60 = new String[]{"60", "10 push ups + 30 sec plank + 10 push ups + 30 sec plank  + 10 push ups + 30 sec plank + 10 push ups + 30 sec plank + 5 push ups+15 Squats", "it's not difficult, you can do it! Let us all work together!"};
    String[] day61 = new String[]{"61", "14 Push ups + 1 min Plank + 14 Push ups + 1 min Plank  + 14 Push ups + 1 min Plank + 14 Push ups+15 Squats", "Do you get up and finish your workout first? or how do you do your routine?"};
    String[] day62 = new String[]{"62", "10 Push ups + 30 sec plank + 10 Push ups + 30 sec plank + 10 Push ups + 30 sec plank + 10 Push ups + 30 sec plank + 10 Push ups+15 Squats", "Warm up before and stretching after these are the key to a good push ups workout"};
    String[] day63 = new String[]{"63", " 15 Push ups + 1 min Plank + 15 Push ups + 1 min Plank+ 15 Push ups + 1 min Plank + 15 Push ups+15 Squats", "4 Sets!"};
    String[] day64 = new String[]{"64", "15 Push ups + 30 sec plank + 15 Push ups + 30 sec plank + 15 Push ups + 30 sec plank + 15 Push ups + 30 sec plank + 7 Push ups+15 Squats", "Take it easy, focus and do it for yourself!"};
    String[] day65 = new String[]{"65", "20 Push ups + 1 min plank + 20 Push ups + 1 min plank + 20 Push ups + 1 min plank + 20 Push ups+15 Squats", "Stay in the game!"};
    String[] day66 = new String[]{"66", "20 Push ups + 1 min plank + 20 Push ups + 1 min plank + 20 Push ups + 1 min plank + 20 Push ups+20 Squats", "It just works, don't think too much. Do your duty and have no expectations, just like our religious text says. Keep on doing!"};
    String[] day67 = new String[]{"67", "22 Push ups + 30 sec plank + 22 Push ups + 30 sec plank + 22 Push ups + 30 sec plank + 22 Push ups + 30 sec plank + 3 Push up+20 Squats", "Yes it is a hard day but you know know the count will go down. Keep on going!!!"};
    String[] day68 = new String[]{"68", "15 Push ups + 30 sec plank + 15 Push ups + 30 sec plank  + 15 Push ups + 30 sec plank + 4 Push ups+20 Squats", "Another easy day!! We have done a lot together, let us not quit now!"};
    String[] day69 = new String[]{"69", "20 Push ups + 30 sec plank + 20 Push ups + 30 sec plank + 20 Push ups  + 30 sec plank + 20 Push ups + 30 sec plank + 10 Push ups+20 Squats", "Challenging days up to the end of the week. You know we will get through this and then it will be easy again!! "};
    String[] day70 = new String[]{"70", "20 Push ups + 30 sec plank + 20 Push ups + 30 sec plank + 20 Push ups + 30 sec plank + 20 Push ups + 30 sec plank + 10 Push ups+20 Squats", "if you find it difficult to do the 20 pushups in one set take break bu do the 5 sets!"};
    String[] day71 = new String[]{"71", "20 Push ups + 30 sec plank + 20 Push ups + 30 sec plank + 20 Push ups  + 30 sec plank + 20 Push ups + 30 sec plank + 10 Push ups+20 Squats", "You are amazing to stick so far with the challenge! It is not easy!"};
    String[] day72 = new String[]{"72", "25 Push ups + 1 min Plank + 25 Push ups + 1 min Plank + 25 Push ups+20 Squats", "Have you noticed it actually takes very less time including the long breaks between the set! Let us stay together and complete it asap!"};
    String[] day73 = new String[]{"73", "25 Push ups + 1 min Plank + 25 Push ups + 1 min Plank + 25 Push ups + 1 min Plank + 25 Push ups+20 Squats", "One more difficult day before it gets easy."};
    String[] day74 = new String[]{"74", "14 Push ups + 1 min Plank + 14 Push ups + 1 min Plank + 14 Push ups + 1 min Plank + 14 Push ups+20 Squats", "Reduced workload again!! Enjoy!"};
    String[] day75 = new String[]{"75", "10 Push ups + 30 sec plank + 10 Push ups + 30 sec plank + 10 Push ups + 30 sec plank + 10 Push ups+ 30 sec plank + 10 Push ups+20 Squats", "It's one of those easy days! :)"};
    String[] day76 = new String[]{"76", "15 Push ups + 1 min Plank + 15 Push ups + 1 min Plank + 15 Push ups + 1 min Plank + 15 Push ups+20 Squats", "Enjoy another easy day!"};
    String[] day77 = new String[]{"77", "10 Push ups + 1 min Plank + 10 Push ups + 1 min Plank + 10 Push ups + 1 min Plank + 10 Push ups+20 Squats", "Enjoy one more easy day!"};
    String[] day78 = new String[]{"78", "15 Push ups + 30 sec plank + 15 Push ups + 30 sec plank + 15 Push ups + 30 sec plank  + 15 Push ups + 30 sec plank + 4 Push ups+20 Squats", "Enjoy one more easy day!"};
    String[] day79 = new String[]{"79", "15 Push ups + 30 sec plank + 15 Push ups + 30 sec plank + 15 Push ups + 30 sec plank + 15 Push ups + 30 sec plank + 7 Push ups+20 Squats", "If you find that it is getting too difficult, you may be doing too many in one set. Try reducing the number of push ups in every set."};
    String[] day80 = new String[]{"80", "10 push ups + 1 min plank + 10 push ups + 1 min plank + 10 push ups + 1 min plank +  5 push ups+20 Squats", "In our program we reduce the number of push ups frequently and then slowly build up again. Doing more push ups at one go is the difficult part."};
    String[] day81 = new String[]{"81", "10 push ups + 30 sec plank + 10 push ups + 30 sec plank + 10 push ups + 30 sec plank + 10 push ups + 30 sec plank + 5 push ups+20 Squats", "Believe me it is an easy day !"};
    String[] day82 = new String[]{"82", "14 Push ups + 1 min Plank + 14 Push ups + 1 min Plank + 14 Push ups + 1 min Plank + 14 Push ups+20 Squats", "You are amazing to stick so far with the challenge! It is not easy!"};
    String[] day83 = new String[]{"83", "10 Push ups + 30 sec plank + 10 Push ups + 30 sec plank + 10 Push ups + 30 sec plank + 10 Push ups + 30 sec plank + 10 Push ups+20 Squats", "Have you noticed it actually takes very less time including the long breaks between the set! Let us stay together and complete it asap!"};
    String[] day84 = new String[]{"84", "15 Push ups + 1 min Plank + 15 Push ups + 1 min Plank + 15 Push ups + 1 min Plank + 15 Push ups+20 Squats", "Last few days remaining!! Let us not give up, give it little bit and let us hang in there and do it! All the best to you and me!"};
    String[] day85 = new String[]{"85", "15 Push ups + 30 sec plank + 15 Push ups + 30 sec plank + 15 Push ups + 30 sec plank + 15 Push ups + 30 sec plank + 7 Push ups+20 Squats", "Let us commit ourself and do it! Get to it, these days its easy days time, now 15 pushups in a day is not that big a challenge! is it?"};
    String[] day86 = new String[]{"86", "20 Push ups + 1 min plank + 20 Push ups + 1 min plank+ 20 Push ups + 1 min plank + 20 Push ups+25 Squats", "You know it goes up to 20 push ups in one set and then it comes down again. We are in the easy week"};
    String[] day87 = new String[]{"87", "10 push ups + 1 min plank + 10 push ups + 1 min plank + 10 push ups + 1 min plank +  5 push ups+25 Squats", "It's easy sets again, don't let it fool you the fatigue of all these days has built up."};
    String[] day88 = new String[]{"88", "10 push ups + 30 sec plank + 10 push ups + 30 sec plank + 10 push ups + 30 sec plank + 10 push ups + 30 sec plank + 5 push ups+25 Squats", "you will have to use your mental strength to get through it. When you think it is most difficult that is when the change is happening! Let us stay in there!"};
    String[] day89 = new String[]{"89", " 14 Push ups + 1 min Plank + 14 Push ups + 1 min Plank + 14 Push ups + 1 min Plank + 14 Push ups+25 Squats", "It's not difficult, let us keep at it, we will do it! just a little bit remaining!!"};
    String[] day90 = new String[]{"90", "10 Push ups + 30 sec plank + 10 Push ups + 30 sec plank + 10 Push ups + 30 sec plank + 10 Push ups + 30 sec plank + 10 Push ups+25 Squats", "It's easy sets again, don't let it fool you the fatigue of all these days has built up."};
    String[] day91 = new String[]{"91", "15 Push ups + 1 min Plank + 15 Push ups + 1 min Plank + 15 Push ups + 1 min Plank + 15 Push ups+25 Squats", "Come on let us do it!! Last bit!"};
    String[] day92 = new String[]{"92", "15 Push ups + 30 sec plank + 15 Push ups + 30 sec plank + 15 Push ups + 30 sec plank + 15 Push ups + 30 sec plank + 7 Push ups+25 Squats", "Keep on going! Last few days!"};
    String[] day93 = new String[]{"93", "20 Push ups + 1 min plank + 20 Push ups + 1 min plank+ 20 Push ups + 1 min plank + 20 Push ups+25 Squats", "20 push ups in a set should not be a difficult task, yes you can do it!"};
    String[] day94 = new String[]{"94", "10 push ups + 1 min plank + 10 push ups + 1 min plank + 10 push ups + 1 min plank +  5 push ups+25 Squats", "Let us take it easy so we can finish strong, just a little bit remaining!"};
    String[] day95 = new String[]{"95", "10 push ups + 30 sec plank + 10 push ups + 30 sec plank + 10 push ups + 30 sec plank + 10 push ups + 30 sec plank + 5 push ups+25 Squats", "Let us take it easy and then for the last 3 days let us try to to more, ok?"};
    String[] day96 = new String[]{"96", "14 Push ups + 1 min Plank + 14 Push ups + 1 min Plank + 14 Push ups + 1 min Plank + 14 Push ups+25 Squats", "Now focus! 22 is the last day of our 100 days. we are right there. let us do it!"};
    String[] day97 = new String[]{"97", "10 Push ups + 30 sec plank + 10 Push ups + 30 sec plank + 10 Push ups + 30 sec plank + 10 Push ups + 30 sec plank + 10 Push ups+25 Squats", "Last easy day!"};
    String[] day98 = new String[]{"98", "10 Push ups + 30 sec plank + 10 Push ups + 30 sec plank + 10 Push ups + 30 sec plank + 10 Push ups + 30 sec plank + 10 Push ups+25 Squats", "On last day 22 August let us do sets of 20 push ups each, no planks and repeat the set for maximum number of times in the day,let us break our personal best, let us see how many we can do! 20 per set is respectable set, make sure you do the perfect form."};
    String[] day99 = new String[]{"99", "10 push ups + 1 min plank + 10 push ups + 1 min plank + 10 push ups + 1 min plank+25 Squats", "Here is the plan, take 21 Aug easy. Do these 3 sets just to get you warmed up. On 22 Aug do each set of 20 and see how many sets you can do to the maximum of your ability. do not spend the entire day on it! Decide a fixed time may be morning or so and see how much you can finish in one sitting. This will be the benchmark you can measure yourself up to."};
    String[] day100 = new String[]{"100", "As many Sets as you can!", "The last day is here! Sleep early, do sets of 20 push ups each and as many push ups as you can. Let us attempt the maximum!"};
    String[] day101 = new String[]{"101", "Congratulations!", "I am sure you all had a maximum push ups day today! Thank your body that helped you achieve it! Take a short rest day for your upper body workout before you get back to daily push ups again. you will find it easy to do push ups all your life if you continue doing at least one set every day."};


    String[][] collection = new String[][]{day1, day2, day3, day4, day5, day6, day7, day8, day9, day10, day11, day12, day13, day14, day15, day16, day17, day18, day19, day20, day21, day22, day23, day24, day25, day26, day27, day28, day29, day30, day31, day32, day33, day34, day35, day36, day37, day38, day39, day40, day41, day42, day43, day44, day45, day46, day47, day48, day49, day50, day51, day52, day53, day54, day55, day56, day57, day58, day59, day60, day61, day62, day63, day64, day65, day66, day67, day68, day69, day70, day71, day72, day73, day74, day75, day76, day77, day78, day79, day80, day81, day82, day83, day84, day85, day86, day87, day88, day89, day90, day91, day92, day93, day94, day95, day96, day97, day98, day99, day100, day101
    };

    //String[] userDatabase[][] = new String[][]{"Bhuvan","23-08-2020"},{"Siddharth","10-01-2020"};

    private Map<String, ArrayList<String>> createMap() {

        final ArrayList<String> datalist1 = new ArrayList<String>();
        datalist1.add("Bhuvan");
        datalist1.add("28-09-2020");
        dataMap.put("Bhuvan", datalist1);

        final ArrayList<String> datalist2 = new ArrayList<String>();
        datalist2.add("Likith");
        datalist2.add("01-09-2020");
        dataMap.put("Likith", datalist2);

        final ArrayList<String> datalist3 = new ArrayList<String>();
        datalist3.add("Siddharth");
        datalist3.add("01-09-2020");
        dataMap.put("Siddharth", datalist3);

        final ArrayList<String> datalist4 = new ArrayList<String>();
        datalist4.add("Sanjay");
        datalist4.add("23-09-2020");
        dataMap.put("Sanjay", datalist4);

        return dataMap;
    }

    private Map<String, ArrayList<String>> addDataMap(String username) {
        final ArrayList<String> datalist1 = new ArrayList<String>();
        datalist1.add(username);
        final SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        final Date date = new Date(System.currentTimeMillis());
        datalist1.add(formatter.format(date));
        dataMap.put(username, datalist1);
        return dataMap;
    }

    private Map<String, ArrayList<String>> deleteDataMap(String username) {
        if (dataMap.containsKey(username))
            dataMap.remove(username);
        return dataMap;
    }

    private Map<String, ArrayList<String>> iterateMap(String username) {
        if (dataMap.containsKey(username))
            //return dataMap.get("1");
            System.out.println("\nData with Key = " + dataMap.get("2"));
            /*final ArrayList<String> maplist = entry.getValue();
            for (final String str : maplist)
                System.out.println("value : " + str);
                /*
             */
        return null;
        }

    private String get2ndValFromList(String username) {
        String doj = null;
        ArrayList<String> maplist = null;
        if (dataMap.containsKey(username))
            maplist = dataMap.get(username);
            if(maplist.size() == 2)
                doj = maplist.get(1);
            else
                System.out.println("data not available");
        return doj;
    }

/*
         * System.out.println("Data with Key 1 = " + dataMap.get("1"));
         * System.out.println("Data with Key 2 = " + dataMap.get("2"));
         * System.out.println("Data with Key 3 = " + dataMap.get("3"));
*/


    public void clickNextDayCount(View View) {

        //taking input
        EditText editUser = (EditText) findViewById(R.id.editUser);
        ImageView up = (ImageView) findViewById(R.id.imageUp);
        EditText editDay = (EditText) findViewById(R.id.editDay);
        String userName = editUser.getText().toString();
        final Map<String, ArrayList<String>> dataMap = createMap();
        if(dataMap.containsKey(userName)){
                TextView textWelcome = (TextView) findViewById(R.id.textWelcome);
                TextView nextDayCount = (TextView) findViewById(R.id.nextDayCount);
                int dayCount = Integer.parseInt(editDay.getText().toString());

 sendPushupDataToSheet(userName, dayCount); // Send data to Google Sheet
                //find count between today's date and day of joining
                String start_date = get2ndValFromList(userName);
                int dayInit = DateOps.findDifferenceCurrentDate(start_date);

                //displaying result
                if (dayCount == dayInit || dayCount == dayInit + 1 || dayCount < dayInit) {

                    if (dayCount == 25 || dayCount == 50 || dayCount == 75) {
                        ImageView congratulations = (ImageView) findViewById(R.id.imageView);
                        System.out.println(dayInit);
                        congratulations.animate().alpha(1).scaleXBy(1).scaleYBy(1).setDuration(2000);
                        up.animate().alpha(0).setDuration(500);
                        textWelcome.setText("Welcome " + userName);
                        TextView textView1 = (TextView) findViewById(R.id.motivationMessage);
                        String motivation = (String) collection[dayCount - 1][2];
                        String nextDayC = (String) collection[dayCount - 1][1];
                        textView1.setText(motivation);
                        nextDayCount.animate().alpha(1);
                        nextDayCount.setText("Day " + editDay.getText().toString() + " -> baseline  +" + nextDayC);
                        } else {
                        up.animate().alpha(0).setDuration(500);
                        textWelcome.setText("Welcome " + userName);
                        TextView textView1 = (TextView) findViewById(R.id.motivationMessage);
                        String motivation = (String) collection[dayCount - 1][2];
                        String nextDayC = (String) collection[dayCount - 1][1];
                        textView1.setText(motivation);
                        nextDayCount.animate().alpha(1);
                        nextDayCount.setText("Day " + editDay.getText().toString() + " -> baseline  +" + nextDayC);
                    }
                }
                    else {
                    TextView textView1 = (TextView) findViewById(R.id.motivationMessage);
                    textView1.setText("come back tomorrow");
                    up.animate().alpha(0).setDuration(500);
                    nextDayCount.animate().alpha(0);

                }
            } else {
                // in case of new user
                TextView textWelcome = (TextView) findViewById(R.id.textWelcome);
                TextView nextDayCount = (TextView) findViewById(R.id.nextDayCount);
                up.animate().alpha(0).setDuration(500);
                textWelcome.setText("Welcome " + userName);
                TextView textView1 = (TextView) findViewById(R.id.motivationMessage);
                String motivation = "please register first to use this app";
                textView1.setText(motivation);
                nextDayCount.animate().alpha(0);

            }

    }


        public void showDatePickerDialog(View view) {
            ImageView up = (ImageView) findViewById(R.id.imageUp);
            EditText editUser = (EditText) findViewById(R.id.editUser);
            String userName = editUser.getText().toString();
            addDataMap(userName);
            TextView textWelcome = (TextView) findViewById(R.id.textWelcome);
            up.animate().alpha(0).setDuration(500);
            textWelcome.setText("Welcome " + userName);
            TextView textView1 = (TextView) findViewById(R.id.motivationMessage);
            String motivation = "this is your Day 0 come back tomorrow to see your count ";
            textView1.setText(motivation);
            TextView nextDayCount = (TextView) findViewById(R.id.nextDayCount);
            nextDayCount.animate().alpha(0);

    }
    public void editDelete(View view) {
        ImageView up = (ImageView) findViewById(R.id.imageUp);
        EditText editUser = (EditText) findViewById(R.id.editUser);
        String userName = editUser.getText().toString();
        deleteDataMap(userName);
        TextView textWelcome = (TextView) findViewById(R.id.textWelcome);
        up.animate().alpha(0).setDuration(500);
        textWelcome.setText("Welcome " + userName);
        TextView textView1 = (TextView) findViewById(R.id.motivationMessage);
        String motivation = "your entry has been cleaned ";
        textView1.setText(motivation);
        TextView nextDayCount = (TextView) findViewById(R.id.nextDayCount);
        nextDayCount.animate().alpha(0);

    }


    //Button Click functionality
    public void goToURL (View View){
            goToUrl ( "https://sanjaymishra.in/do-you-like-to-take-a-personal-challenge/");
        }
    public void goToViewURL (View View){
        goToUrl ( "https://sanjaymishra.in/results-for-100-days-pushup-challenge/");
    }

    private void goToUrl (String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }
    public void fade1(View view){
        ImageView congratulations = (ImageView) findViewById(R.id.imageView);
        congratulations.animate().alpha(0).scaleXBy(-1).scaleYBy(-1).setDuration(1000);

    }

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
 setContentView(R.layout.activity_main);

        // Configure sign-in to request the user's ID, email address, and basic
        // profile. ID and basic profile are included in DEFAULT_SIGN_IN.
 GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
 .requestEmail()
 .build();

        // Build a GoogleSignInClient with the options specified by gso.
 mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        // Set the dimensions of the sign-in button.
 signInButton = findViewById(R.id.sign_in_button);
 signInButton.setSize(SignInButton.SIZE_STANDARD);

 signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
 signIn();
            }
        });

        // Find the View Leaderboard button and set an OnClickListener
        viewLeaderboardButton = findViewById(R.id.view_leaderboard_button);
        viewLeaderboardButton.setOnClickListener(new View.OnClickListener() {
 @Override
 public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LeaderboardActivity.class));
            }
        });

    }
 private void signIn() {
 Intent signInIntent = mGoogleSignInClient.getSignInIntent();
 startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
 super.onActivityResult(requestCode, resultCode, data);

 // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
 if (requestCode == RC_SIGN_IN) {
 // The Task returned from this call is always completed, no need to attach
 // a listener.
 Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
 handleSignInResult(task);
 }
    }

 private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
 try {
 GoogleSignInAccount account = completedTask.getResult(ApiException.class);
 // Signed in successfully, log user information.
 Log.d(TAG, "signInResult: success");
 Log.d(TAG, "Display Name: " + account.getDisplayName());
 Log.d(TAG, "Email: " + account.getEmail());
 // You can also get the user's ID and profile picture URI
 // String personId = account.getId();
 // Uri personPhoto = account.getPhotoUrl();

 } catch (ApiException e) {
 // The ApiException status code indicates the detailed failure reason.
 // Please refer to the GoogleSignInStatusCodes class reference for more information.
 Log.w(TAG, "signInResult:failed code=" + e.getStatusCode());
 // You could show an error message to the user here, e.g., with a Toast
 }
    }

    private void sendPushupDataToSheet(String username, int pushupCount) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection urlConnection = null;
                try {
                    URL url = new URL(SCRIPT_URL);
                    urlConnection = (HttpURLConnection) url.openConnection();
                    urlConnection.setRequestMethod("POST");
                    urlConnection.setRequestProperty("Content-Type", "application/json; utf-8");
                    urlConnection.setDoOutput(true);

                    String jsonInputString = "{\"username\": \"" + username + "\", \"pushupCount\": " + pushupCount + "}";

                    try(OutputStream os = urlConnection.getOutputStream()) {
                        byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
                        os.write(input, 0, input.length);
                    }

                    int responseCode = urlConnection.getResponseCode();
                    Log.d(TAG, "HTTP POST response code: " + responseCode);

                } catch (Exception e) {
                    Log.e(TAG, "Error sending data to Google Sheet", e);
                } finally {
                    if (urlConnection != null) urlConnection.disconnect();
                }
            }
        }).start();
    }
}