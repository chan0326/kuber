'use client'

import MoveButton from "@/app/atoms/button/MoveButton";
import Columns from "@/app/components/article/module/columns";
import { findArticlesByBoardId } from "@/app/components/article/service/article.service";
import { getArticles } from "@/app/components/article/service/article.slice";
import { PG } from "@/app/components/common/enums/PG";
import { DataGrid } from "@mui/x-data-grid";
import Link from "next/link";
import { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";

const cards = [
    "https://www.tailwindtap.com/assets/components/horizontal-carousel/mountain-nightview.jpg",
    "https://www.tailwindtap.com/assets/components/horizontal-carousel/autumn.jpg",
    "https://www.tailwindtap.com/assets/components/horizontal-carousel/babypinetree.jpg",
    "https://www.tailwindtap.com/assets/components/horizontal-carousel/beach.jpg",
    "https://www.tailwindtap.com/assets/components/horizontal-carousel/purpleflowers.jpg",
    "https://www.tailwindtap.com/assets/components/horizontal-carousel/starrysky.jpg",
    "https://www.tailwindtap.com/assets/components/horizontal-carousel/lake.jpg",
  ];

  export default function SearchBoardIdPage({params}: any){
    const dispatch = useDispatch()
    const articles = useSelector(getArticles)

    useEffect(() => {
        dispatch(findArticlesByBoardId(params.id))
        console.log(params.id)
    }, [])

    return(<>
        <h2>게시글 내용</h2>
        <MoveButton text={'글쓰기'} path={`${PG.ARTICLE}/save/${params.id}`}/>
        
        <div style={{ height: 400, width: "100%" }}>
      {articles && <DataGrid // 
         rows={articles}
        columns={Columns()}
        pageSizeOptions={[5,10,20]} // 4-1
        checkboxSelection
      />}
    </div>
    </>
      )
    





  }