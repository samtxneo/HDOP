function doPost(e) {
  var sheet = SpreadsheetApp.getActiveSpreadsheet().getSheets()[0];
  var data = JSON.parse(e.postData.contents);
  var username = data.username;
  var pushupCount = data.pushupCount;
  sheet.appendRow([username, pushupCount]);

  return ContentService.createTextOutput("Data received and recorded.");
}