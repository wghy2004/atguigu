(function(a){a.Loading=a.Loading||{};if(top!=window){a.Loading=parent.$.Loading}else{a.Loading.show=function(b){a.blockUI({css:{top:"10px",backgroundColor:"#f8c684",border:"1px solid #f7b885",color:"#fff",width:"auto",padding:"0px 40px"},message:b,showOverlay:false})};a.Loading.success=function(b){a.blockUI({css:{top:"10px",backgroundColor:"#9adda7",border:"1px solid #a8cbb9",color:"#fff",width:"auto",padding:"0px 40px 0px 20px"},message:"<div class='success'>"+b+"</div>",showOverlay:false});setTimeout(a.unblockUI,5000)};a.Loading.error=function(b){a.blockUI({css:{top:"10px",backgroundColor:"#faa499",border:"1px solid #f49292",color:"#fff",width:"auto",padding:"0px 40px 0px 20px"},message:"<div class='error'>"+b+"</div>",showOverlay:false});setTimeout(a.unblockUI,5000)};a.Loading.hide=function(){a.unblockUI()}}})(jQuery);