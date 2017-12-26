<html >
<head>
 <link rel="stylesheet" href="zamzar.css?v=8d8d917d0ebaaf9e5b1dbc1e5a0ea061" type="text/css" media="screen,projection">
 <style type="text/css">
div.step1 {padding-top: 15px; width: 190px; padding-right: 10px; float: left;}
div.step4 {padding-left: 10px; padding-top: 15px; float: left; width: 165px;}
</style>
</head>
<body id="body" bgcolor="FFFFFF"><div class="page-container">
<div class = "login-container" align="center" style="margin:20,0,30,0; background-color:#0000FF; height:50px;">
<header style="padding-top:10px"><b> Upload And DownLoad Your File</b></header></div>
<p></p><br>
<div class="body"><br><h1 style="overflow: hidden; padding: 0px; margin: 50px;">Upload and Download File</h1><table class="body" style="cellspacing:0;cellpadding:0; border:0; width:100%">
                    <tbody><tr>
                        <td width="294" valign="top">
                            <table class="body" style=" width:294 ; cellspacing:0;cellpadding:0 ;border:0">
                                <tbody><tr>
                                    <td>
                                        <br>
                                        You can <b><i>Upload Your</i></b> - <a  href="#tool">XLSX file</a> - and the Download it.
                                        <br><p align="center"><img src="\C:\Users\abid\Desktop\xlsx.png" width="75px" title="convert XLSX to CSV" alt="convert XLSX to CSV"><img src="\C:\Users\abid\Desktop\csv.png" width="100px" title="convert XLSX to CSV" alt="convert XLSX to CSV"></p></td>
                                </tr>
                            </tbody></table>
                        <td>
                           <div class="blueBox">
                                <h2>How to Upload and Download a XLSX file ?</h2>
                                <ol class="convert-ol">
                                    <li>Choose the XLSX file that you want to upload.</li>
                                    <li>Click "Upload" to Upload your XLSX file.</li>
                                    <li>Once uploaded you can download it from the link</li>
                                 </ol>
                                </div>
                        </td>
                    </tr>
                </tbody></table><div id="main">
	<div class="header">
    <div class="acc_container"><br>   
<form name="fileForm" id="fileForm" class="form"  action="UploadDownloadFileServlet" method="post" enctype="multipart/form-data">
    
    <div id="tabtable" class="conversionBox">
        <div id="steps" class="steps clearfix">
            <div class="step1" style="font-size: 13px; font-family: Tahoma,sans-serif; float: left; padding-right: 100px; padding-top: 15px;padding-left:30px width: 190px;">
                 <h3>Step 1</h3>Choose the <a href="/url/">XLSX</a> File you <br> wish to upload ...                <p></p><table style="cellpadding:0; cellspacing:0; border:0">
                  <tbody><tr>
                    <td id="fileInputElementParent">
                     <input id="inputFile" class="bodyBig" type="file" name="fileName" size="15">
                    </td>
                  </tr>
                  </tbody></table><p></p>
            </div> 
            <div class="step2" style="font-size: 13px; font-family: Tahoma,sans-serif;paddding-left:100px;padding-right:100px">
                <h3>Step 2</h3>Upload Your  file now <p><input id="uploadButton" type="submit" class="bodyBig" value="Upload"></p></div><div id="dnd-target" class="dnd-display">Drop your files here</div>            
        </div>
</div>
</form>      </div><br><br>
      </div>
     <footer style="background-color:silver;height:150px;">
  <h3>You can Perform other opeation too with your Excel File </h3>
      <nav>
      <ol>
      <li><a href="Read.jsp">Read Your Excel File</a></li>
      <li><a href="ReadX.jsp">Read X Number of Data From Your Excel File</a></li>
      <li><a href="Save.jsp">Save Your Excel File into Database</a></li>
      <li><a href="UPLd.jsp">Upload and Download Your Excel File</a></li>
      </ol>
      </nav></footer>
      </div></div></div>
      
    </body>
</html>