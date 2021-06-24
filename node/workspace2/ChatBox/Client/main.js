const {app,BrowserWindow} = require("electron");
const process = require("process");
// electron
let win = null;
function createWindow()
{
  let settings = {width: 600, height: 600}
  win = new BrowserWindow(settings);
  win.loadURL(`file://${process.cwd()}/dist/Chatbox/index.html`);
  
  // for dev tool
  //win.webContents.openDevTools();
  win.on('closed', function(){
    win = null;
  });
}

app.on('ready',createWindow)
app.on('window-all-closed', function(){
  if(process.platform !=='darwin'){
    app.quit()
  }
})
app.on("activate",function(){
  if(win === null)
  {
    createWindow();
  }
})