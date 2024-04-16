'use client'

import { DataGrid } from '@mui/x-data-grid';
import { useState, useEffect } from "react"
import { NextPage } from "next";
import { findAllArticles } from "@/app/components/article/service/article.service";
import { useSelector, useDispatch } from 'react-redux'
import { getAllArticles } from "@/app/components/article/service/article.slice";
import Columns from "@/app/components/article/module/columns";



const ArticlesPage: NextPage = () => {
    const dispatch = useDispatch()
    const allArticles: [] = useSelector(getAllArticles)

    if (allArticles !== undefined) {
        console.log('allArticles is not undefined')

        console.log('length is ' + allArticles.length)
        for (let i = 0; i < allArticles.length; i++) {
            console.log(JSON.stringify(allArticles[i]))
        }
    } else {
        console.log('allArticles is undefined')
    }

    useEffect(() => {
        dispatch(findAllArticles(1))
    }, [])

    return (<>
        <h2>게시글 내용</h2>
        <div style={{ height: 400, width: "100%" }}>
      {allArticles && <DataGrid // 
         rows={allArticles}
        columns={Columns()}
        pageSizeOptions={[5,10,20]} // 4-1
        checkboxSelection
      />}
    </div>
    </>)
}

export default ArticlesPage