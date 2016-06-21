$(document).ready(function() {
	jQuery(function($) {
	    $(".autoNumber").autoNumeric("init", {aSep:".", aDec:",", mDec:"2", vMin:"0.00", vMax:"999999.99"});
	});
	jQuery(function($) {
	    $(".autoInt").autoNumeric("init", {vMin:"00", vMax:"99"});
	});
	jQuery(function($) {
	    $(".autoPerc").autoNumeric("init", {aSep:".", aDec:",", mDec:"2", vMin:"0.00", vMax:"99.99"});
	});			
	$(".texto").on("keyup", function() {
        if (this.value[0] != this.value[0].toUpperCase()) {
            // store current positions in variables
            var start = this.selectionStart;
            var end = this.selectionEnd; 
            this.value = this.value[0].toUpperCase() + this.value.substring(1);
            // restore from variables...
            this.setSelectionRange(start, end);
        }
    });
	/*jQuery(function($) {
		PF("lightbox").show();
	});*/
	$(".tree-toggle").click(function () {
		$(this).parent().children("ul.tree").toggle(200);
		
		var i = $(this).find(".fa-plus");
		if (i.length > 0) {
			
			i.removeClass("fa-plus");
			i.removeClass("fa-minus");
			
		} else {
			
			i = $(this).find(".fa-minus");
			i.removeClass("fa-minus");
			i.addClass("fa-plus");
						
		}
		
	});
});

Pace.on("start", function() {
	//PF("lightbox").show();
	var lightbox = $(document).find("#lightbox");
	
	lightbox.removeClass("ui-lightbox ui-widget ui-helper-hidden ui-corner-all ui-shadow");
	lightbox.addClass("ui-widget-overlay");
	
});
Pace.on("restart", function() {
	//PF("lightbox").show();
});
Pace.on("done", function() {
	//PF("lightbox").hide();
	var lightbox = $(document).find("#lightbox");
	
	lightbox.removeClass("ui-widget-overlay");
	lightbox.addClass("ui-lightbox ui-widget ui-helper-hidden ui-corner-all ui-shadow");
});

/*
//patch to fix a problem that the context menu disappears after update
//delay the show to occure after the update 
var siteFunctions = {
    patchContextMenuShow: function() {
        var protShow = PrimeFaces.widget.ContextMenu.prototype.show;
        siteFunctions.patchContextMenuShow.lastEvent = null;
        PrimeFaces.widget.ContextMenu.prototype.show = function(e) {
            var ret;
            if (e) {
				//saving last event
                siteFunctions.patchContextMenuShow.lastEvent = e;
                siteFunctions.patchContextMenuShow.lastEventArg = arguments;
                siteFunctions.patchContextMenuShow.lastEventContext = this;
            } else if (siteFunctions.patchContextMenuShow.lastEvent) {
				//executing last event
                ret = protShow.apply(siteFunctions.patchContextMenuShow.lastEventContext, siteFunctions.patchContextMenuShow.lastEventArg);
				//clearing last event
                siteFunctions.patchContextMenuShow.lastEvent = null;
            }
            return ret;
        };
    }
};
$(document).ready(function() {
    try {
        siteFunctions.patchContextMenuShow();
    } catch (e) {
        console.error(e);
    }
});
$(document.getElementById("form:solicitacoesOSE")).bind("contextmenu", function (event) {
  	event.preventDefault();
});
*/