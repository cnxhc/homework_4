window.onload=function(){
	//定义通过class名获取对象的方法
	function getClass(oParent,sClass){
		var aEle=oParent.getElementsByTagName("*");
		var aResult=[];
		var i=0;
		for (var i = 0; i < aEle.length; i++) {
			if (aEle[i].className==sClass) {
				aResult.push(aEle[i]);
			}
		}
		return aResult;
	}

	//获取页面元素
	var aNum=getClass(document,'num');
	var oText=document.getElementById('text');
	var oText1=document.getElementById('text1');
	var aPer=getClass(document,'oper');
	var oDeng=getClass(document,'deng')[0];
	var oClear=getClass(document,'clea')[0];
	var oSin=getClass(document,'sin')[0];
	var oCos=getClass(document,'cos')[0];
	var oTan=getClass(document,'tan')[0];
	var lastOperIndex;
	
	//计算三角函数 cos()
	oCos.onclick=function(){
		var re=/([0-9])+$/;
		var value=re.exec(oText.value);
		//这样可以计算输入 90+cos90，
		oText.value=eval('Math.cos('+value[0]+'/180*Math.PI)')+eval(oText.value)-value[0];
	}

	//计算三角函数 sin()
	oSin.onclick=function(){
		var re=/([0-9])+$/;
		var value=re.exec(oText.value);
		oText.value=eval('Math.sin('+value[0]+'/180*Math.PI)')+eval(oText.value)-value[0];
	}

	//计算三角函数tan()
	oTan.onclick=function(){
		var re=/([0-9])+$/;
		var value=re.exec(oText.value);
		if(value[0]==90){
			alert("输入有误,tan90 无意义");
		}else{
		oText.value=eval('Math.tan('+value[0]+'/180*Math.PI)')+eval(oText.value)-value[0];
		}
	}

	//计算结果，显示结果
	oDeng.onclick=function(){
		var re=/^[+*.\\/]/;
		if (oText.value=='' || re.test(oText.value)) {
			oText.value='';
			return;
		}else{
			var n=eval(oText.value);
			if(isNaN(n)|| n=="Infinity" || n=="-Infinity"){
				alert('输入有误,请从新输入');
				oText.value="";
			}else{
				oText.value=n;
			}
		}	
	}

	//清屏
	oClear.onclick=function(){
		oText.value='';
	}

	//获取用户点击的数字

		for (var i = 0; i < aNum.length; i++) {
			aNum[i].onclick=function(){	
			var re1 = /^([0]\d+)$/;	
				var value=oText.value;
				//对输入小数的判断
				if ((((value.length>0 && re1.test(value.substring(value.length-1))
						|| (value.length==0)
						||(value.length>0 && value.indexOf('.',lastOperIndex)!=-1)))
						&& this.innerHTML=='.')) {
					return;
				}
				var r=value.split("/[+-\\*\\/]/");
				value+=this.innerHTML;
				var r=value.split("+");
				if ( r.indexOf('.')!=-1) {
					if (this.innerHTML=='.') {
						return;	
					}	
				}
				oText.value += this.innerHTML;
				if (re1.test(oText.value)) {
					oText.value = this.innerHTML;
				}
			}
		}


	//获取用户点击的运算符号
		for (var i = 0; i < aPer.length; i++) {

			aPer[i].onclick=function(){
				if (oText.length==0) {
					return;
				}
				if(oText.value.length>0){
					switch(oText.value.charAt(oText.value.length-1)){
						case '+':
						case '-':
						case '*':
						case '/':
						return;
						break;
					}
				}

				oText.value+=this.innerHTML;
				lastOperIndex=oText.value.length-1;
			}
		}

}