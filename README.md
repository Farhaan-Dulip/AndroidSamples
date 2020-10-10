# Android Samples in Kotlin

<img src="https://www.project-disco.org/wp-content/uploads/2018/04/Android-logo.jpg"></img>

<h2> To help you understand some fundamental Android APIs and coding practices, a variety of sample code is available from the Android SDK Manager. You can easily create new Android projects with the downloaded samples, modify them if you'd like, and then run them on an emulator or device.</h2>

<h3> 1. Start New Activity </h3>

To start new (another) Android Activity from an Activity : In the current Activity, create an Intent with current Activity's context and Next Activity Class passed as arguments.

    val button = findViewById<Button>(R.id.button)
    val editTextName = findViewById<EditText>(R.id.edit_text_name)
    val editTextAge = findViewById<EditText>(R.id.edit_text_age)

    button.setOnClickListener {
        val name = editTextName.text.toString().trim()
        val age = editTextAge.text.toString().trim().toInt()

        val intent = Intent(this, WelcomeActivity::class.java)
        intent.putExtra(EXTRA_NAME, name)
        intent.putExtra(EXTRA_AGE, age)
        startActivity(intent)
    }
	
<h3> 2. Send SMS </h3>

In Android, you can use SmsManager API or device’s Built-in SMS application to send a SMS message. In this tutorial, we show you two basic examples to send SMS message.

	val buttonNative = findViewById<Button>(R.id.button_native)
	val buttonApi = findViewById<Button>(R.id.button_api)

	editTextMobileNo = findViewById<EditText>(R.id.edit_text_mobile_no)
	editTextMessage = findViewById<EditText>(R.id.edit_text_message)

	buttonNative.setOnClickListener {
		val mobileNo = getMobileNo()
		val message = getMessage()

		val uri = Uri.parse("smsto:$mobileNo")
		val intent = Intent(Intent.ACTION_SENDTO, uri)
		intent.putExtra("sms_body", message)
		startActivity(intent)
	}

	buttonApi.setOnClickListener {
		val mobileNo = getMobileNo()
		val message = getMessage()

		val smsManager = SmsManager.getDefault() as SmsManager
		smsManager.sendTextMessage(mobileNo, null, message, null, null)
	}
	
<h3> 3. Show Toast </h3>

Toast in Android is used to display a piece of text for a short span of time. When Toast is made, the piece of text is appears on the screen, stays there on the screen for about 2 or 3 to 5 seconds and disappears.

	val button = findViewById<Button>(R.id.button)

	button.setOnClickListener { view ->
		Toast.makeText(this, "Hi, happy coding...", Toast.LENGTH_SHORT).show()
	}
	
<h3> 4. Show Snackbar </h3>

Android Snackbar is a material design component introduced with API 22.2.0. The functionality would resemble Android Toast, but with Snackbar, Snackbar could be dismissed by user or an action listener could be setup to respond to user actions.

	val fab = findViewById<FloatingActionButton>(R.id.fab)

	fab.setOnClickListener { view ->
		Snackbar.make(view, "Do you want to open Settings", Snackbar.LENGTH_LONG)
			.setAction("Yes") {
				startActivity(Intent(Settings.ACTION_SETTINGS))
			}.show()
	}
