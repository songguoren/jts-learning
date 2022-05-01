package com.leokok.jts.learning.jts.core.index;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;
import org.geotools.geojson.feature.FeatureJSON;
import org.geotools.geojson.geom.GeometryJSON;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.index.hprtree.HPRtree;
import org.opengis.feature.simple.SimpleFeature;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

/**
 * 基于点的索引测试
 */
public class SpatialPointIndexTest {

    public static void main(String[] args) throws IOException, ParseException {

        //空间索引
        //Quadtree 四×树
        HPRtree hpRtree = new HPRtree();


        GeometryJSON gjson = new GeometryJSON();
        FeatureJSON fjson = new FeatureJSON();

        //加载几何数据
        JSONObject polygons = JSON.parseObject(FileUtils.readFileToString(new File(SpatialIndexTest.class.getResource("/").getPath()+"/geojson/polygon.geojson"), "UTF-8"));
        JSONObject polgonObj = polygons.getJSONArray("features").getJSONObject(0);
        Geometry polgonGeo = gjson.readPolygon(polgonObj.toJSONString());

        System.out.println("polgon边界:"+polgonGeo.getEnvelope().toText());


        //加载线数据
        JSONObject jsonObject = JSON.parseObject(FileUtils.readFileToString(new File(SpatialIndexTest.class.getResource("/").getPath()+"/geojson/ponits.geojson"), "UTF-8"));

        JSONArray jsonArray = jsonObject.getJSONArray("features");


        for (int i=0; i<jsonArray.size();i++){
            String geoStr = jsonArray.getString(i);
            SimpleFeature simpleFeature = fjson.readFeature(geoStr);
            Geometry geometry = (Geometry) simpleFeature.getDefaultGeometry();
            String osmId = (String)simpleFeature.getAttribute("osm_id");
            hpRtree.insert(geometry.getEnvelopeInternal(), osmId);


        }

        //查询耗时
        long startTime = System.currentTimeMillis();
        List<String>  osmIdList = hpRtree.query(polgonGeo.getEnvelopeInternal());
        long endTime = System.currentTimeMillis();

        System.out.println("数据总量:["+jsonArray.size()+"],hprTree命中:["+osmIdList.size()+"]条,查询耗时["+(endTime-startTime)+"]MS");

        String pids = "";
        for(String e : osmIdList){
            pids += "'"+e+"',";
        }
        System.out.println("匹配到的数据id:"+pids);





    }
}
