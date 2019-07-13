 var map = null;
function initMap() {
   var markerSource = new ol.source.Vector();

    var markerStyle = new ol.style.Style({
      image: new ol.style.Icon(/** @type {olx.style.IconOptions} */ ({
    	anchor: [0.5, 25],
        anchorXUnits: 'fraction',
        anchorYUnits: 'pixels',
        opacity: 0.75,
        src: '/images/demo/maps-and-flags24.png'
      }))
    });
    map = new ol.Map({
        target: document.getElementById('map'),
        layers: [
          new ol.layer.Tile({
            source: new ol.source.OSM()
          }),
          new ol.layer.Vector({
              source: markerSource,
              style: markerStyle,
            }),
         
        ],
        view: new ol.View({
          center: ol.proj.transform([108.24147284030913, 16.055032591348834], 'EPSG:4326', 'EPSG:900913'),
          zoom: 17
        })
      });
    
    
	  var iconFeatures = [];

	  var iconFeature = new ol.Feature({
	    geometry: new ol.geom.Point(ol.proj.transform([108.24147284030913, 16.055032591348834], 'EPSG:4326',
	      'EPSG:900913')),
	    name: 'Null Island',
	    population: 4000,
	    rainfall: 500
	  });

	  markerSource.addFeature(iconFeature);
	  flash(iconFeature, 2000);
    
    function addMarker(lon, lat) {
	  console.log('lon:', lon);
	  console.log('lat:', lat);

	  var iconFeatures = [];

	  var iconFeature = new ol.Feature({
	    geometry: new ol.geom.Point(ol.proj.transform([lon, lat], 'EPSG:4326',
	      'EPSG:900913')),
	    name: 'Null Island',
	    population: 4000,
	    rainfall: 500
	  });

	  markerSource.addFeature(iconFeature);
	  flash(iconFeature, 2000);
	  
	}
}

function flash(feature, duration) {
	  var start = +new Date();
	  var listenerKey; // to remove the listener after the duration

	  function animate(event) {
	    // canvas context where the effect will be drawn
	    var vectorContext = event.vectorContext;
	    var frameState = event.frameState;

	    // create a clone of the original ol.Feature
	    // on each browser frame a new style will be applied
	    var flashGeom = feature.getGeometry().clone();
	    var elapsed = frameState.time - start;
	    var elapsedRatio = elapsed / duration;
	    // radius will be 5 at start and 30 at end.
	    var radius = ol.easing.easeOut(elapsedRatio) * 25 + 5;
	    var opacity = ol.easing.easeOut(1 - elapsedRatio);

	    // you can customize here the style
	    // like color, width
	    var style = new ol.style.Style({
	      image: new ol.style.Circle({
	        radius: radius,
	        snapToPixel: false,
	        stroke: new ol.style.Stroke({
	          color: [51, 51, 51, opacity],
	          width: 0.25 + opacity
	        })
	      })
	    });

	    vectorContext.setStyle(style);
	    vectorContext.drawGeometry(flashGeom);
	    if (elapsed > duration) { // stop the effect
	      ol.Observable.unByKey(listenerKey);
	      return;
	    }
	    // tell OL3 to continue postcompose animation
	    map.render();
	  }

	  listenerKey = map.on('postcompose', animate);
	}
$(document).ready(function(){
	initMap();
});