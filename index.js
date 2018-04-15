/**
 * Commandes :
 * npm install
 * npm install -g firebase-tools
 * firebase login
 * firebase use --add
 *
 * Pour déployer : firebase deploy --only functions
 * Pour tester en local : firebase serve --only functions
 */
const functions = require('firebase-functions');
const admin = require('firebase-admin');
admin.initializeApp(functions.config().firebase);

// Requête à faire sur /sendFCMMessage
exports.sendFCMMessage = functions.https.onRequest((request, response) => {
  var db = admin.database();
  var ref = db.ref("Users/admin/token");

  // Attach an asynchronous callback to read the data at our posts reference
  ref.on("value", function(snapshot) {
      var token = snapshot.val();
      sendFCMMessage(token, "www.google.com");
      return response.status(200);
  }, function (errorObject) {
    console.log("The read failed: " + errorObject.code);
    return response.status(500);
  });

});

function sendFCMMessage(token, url) {
  const payload = {
    data: {
      url: `${url}`
    }
  };

  return admin.messaging().sendToDevice(token, payload);
}
